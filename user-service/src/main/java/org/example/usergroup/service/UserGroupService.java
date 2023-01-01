package org.example.usergroup.service;

import org.example.user.dto.APIUserResponseDTO;
import org.example.usergroup.dto.APIUserGroupRequestDTO;
import org.example.usergroup.dto.APIUserGroupResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserGroupService {

    List<APIUserGroupResponseDTO> findAllUserGroups();

    void createUserGroup(APIUserGroupRequestDTO apiUserGroupRequestDTO);

    Optional<APIUserGroupResponseDTO> findUserGroupById(Integer id);

    List<APIUserResponseDTO> findByuserGroupIdLike(Integer userGroupId);

}
