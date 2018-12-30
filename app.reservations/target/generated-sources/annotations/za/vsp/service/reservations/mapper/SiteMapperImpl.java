package za.vsp.service.reservations.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import za.vsp.service.reservations.model.Site;
import za.vsp.service.reservations.pojo.SiteDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-30T14:24:50+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_91 (Oracle Corporation)"
)
public class SiteMapperImpl implements SiteMapper {

    @Override
    public List<SiteDto> sitesToSiteCollection(Iterable<Site> sites) {
        if ( sites == null ) {
            return null;
        }

        List<SiteDto> list = new ArrayList<SiteDto>();
        for ( Site site : sites ) {
            list.add( siteToSiteDto( site ) );
        }

        return list;
    }

    @Override
    public SiteDto siteToSiteDto(Site site) {
        if ( site == null ) {
            return null;
        }

        SiteDto siteDto = new SiteDto();

        siteDto.setId( site.getId() );
        siteDto.setRegion( site.getRegion() );
        siteDto.setSiteId( site.getSiteId() );
        siteDto.setGsm( site.isGsm() );
        siteDto.setG3( site.isG3() );
        siteDto.setLte( site.isLte() );
        siteDto.setProposedSiteName( site.getProposedSiteName() );
        siteDto.setStatus( site.getStatus() );
        siteDto.setDate( site.getDate() );
        siteDto.setUser( site.getUser() );

        return siteDto;
    }
}
