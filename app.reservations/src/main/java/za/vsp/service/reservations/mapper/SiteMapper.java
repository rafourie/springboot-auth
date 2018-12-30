package za.vsp.service.reservations.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import za.vsp.service.reservations.model.Site;
import za.vsp.service.reservations.pojo.SiteDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SiteMapper {

  SiteMapper INSTANCE = Mappers.getMapper(SiteMapper.class);

  List<SiteDto> sitesToSiteCollection(final Iterable<Site> sites);

  SiteDto siteToSiteDto(final Site site);
}
