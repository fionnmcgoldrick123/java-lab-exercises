package ie.atu.sw;

import java.util.List;
import java.util.Objects.*;

public record Patient(String id, String name, int age, String medicalHistory, List<String> scheduledAppointments) {
	Patient{
		requireNonNull();
	}
}
