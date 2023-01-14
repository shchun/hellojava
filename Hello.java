import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello my java 2");

		Flux<Integer> flux = Flux.just(1, 2, 3);

		flux.subscribe(new Subscriber<>() {
			@Override
			public void onSubscribe(Subscription subscription) {
				System.out.println("onSubscribe");
				subscription.request(Integer.MAX_VALUE);
			}

			@Override
			public void onNext(Integer integer) {
				System.out.println("onNext :" + integer);
			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("onError :" + throwable);
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");

			}
		});
	}
}
