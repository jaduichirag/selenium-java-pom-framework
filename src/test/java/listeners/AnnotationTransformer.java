package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import utils.RetryAnalyzer;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    @SuppressWarnings("rawtypes")
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {

        Class<? extends IRetryAnalyzer> retryAnalyzer =
                annotation.getRetryAnalyzerClass();

        if (retryAnalyzer == null) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }
}