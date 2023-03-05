package ai.freightfox.repo;

import org.springframework.data.repository.CrudRepository;

import ai.freightfox.entity.ZipDetail;

public interface ZipDetailRepo extends CrudRepository<ZipDetail, String> {

}
