package com.grassopasquale.InterfacesDAO;

import com.grassopasquale.model.BrandModel;

public interface BrandDAO {
	public BrandModel getBrandInfo(String name_brand);
	public void updateBrandInfo(String name_brand);
	public void insertBrand(BrandModel brandModel);
}
