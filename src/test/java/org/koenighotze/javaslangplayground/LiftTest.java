package org.koenighotze.javaslangplayground;

import org.junit.Test;

import static javaslang.Function1.lift;
import static org.assertj.core.api.Assertions.*;

/**
 * @author David Schmitz
 */
public class LiftTest {

    private static String parseIban(String request) throws IllegalArgumentException {
        if (request.length() > 5) {
            return request.toUpperCase();
        }

        throw new IllegalArgumentException(request + " is too short");
    }

    @Test
    public void classic_usage() {
        String iban;
        try {
            iban = parseIban("AL47");
        }
        catch (IllegalArgumentException ex) {
            iban = "";
        }
        assertThat(iban).isEqualTo("");
    }

    @Test
    public void safe_op() {
        //@formatter:off
        String iban =
            lift(LiftTest::parseIban)
            .apply("AL47")
            .getOrElse("");
        //@formatter:on
        assertThat(iban).isEqualTo("");
    }
}
