package racingcar;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("우승자가 1명이면 우승자를 1명 반환한다.")
    void getWinnerOne() {
        //arrange
        Car car1 = new Car("car1", 2);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 1);
        Cars cars = new Cars(Lists.newArrayList(car1, car2, car3));

        //act
        Game game = new Game(cars);
        List<Car> winner = game.getWinner();

        //assert
        assertThat(winner).hasSize(1);
        assertThat(winner.get(0).getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자가 2명이면 우승자를 2명 반환한다.")
    void getWinnerTwo() {
        //arrange
        Car car1 = new Car("car1", 2);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 1);
        Cars cars = new Cars(Lists.newArrayList(car1, car2, car3));

        //act
        Game game = new Game(cars);
        List<Car> winner = game.getWinner();

        //assert
        assertThat(winner).hasSize(2);
        assertThat(winner.get(0).getName()).isEqualTo("car1");
        assertThat(winner.get(1).getName()).isEqualTo("car2");

    }
}
