package tech.jhipster.config.mapstruct;

import java.util.ArrayList;
import java.util.List;
import org.mapstruct.ap.internal.model.Annotation;
import org.mapstruct.ap.internal.model.Mapper;
import org.mapstruct.ap.internal.processor.SpringComponentProcessor;

public class LazySpringComponentProcessor extends SpringComponentProcessor  {

  @Override
  protected String getComponentModelIdentifier() {
    return "springlazy";
  }

  @Override
  protected List<Annotation> getMapperReferenceAnnotations() {
    List<Annotation> annotations = new ArrayList<>(super.getMapperReferenceAnnotations());
    annotations.add(lazy());
    return annotations;
  }

  @Override
  protected List<Annotation> getDelegatorReferenceAnnotations(Mapper mapper) {
    List<Annotation> annotations = new ArrayList<>(super.getDelegatorReferenceAnnotations(mapper));
    annotations.add(lazy());
    return annotations;
  }

  private Annotation lazy() {
    return new Annotation( getTypeFactory().getType( "org.springframework.context.annotation.Lazy" ) );
  }
}