package com.waner.primary.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.waner.primary.web.entity.TravelComment;
import com.waner.primary.web.entity.TravelEssayComment;
import com.waner.primary.web.vo.CommentWithUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelCommentMapper extends BaseMapper<TravelComment> {
  int deleteByPrimaryKey(Integer id);

  int insertTravelCommentMapper(TravelComment record);

  int insertSelective(TravelComment record);

  TravelComment selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(TravelComment record);

  int updateByPrimaryKey(TravelComment record);

  int insertEssayCommentRelative(
      @Param("essayId") Integer essayId, @Param("commentId") Integer commentId);

  IPage<CommentWithUser> queryCommentsWithUser(Page pageHelper, @Param("essayId") Integer essayId);

  int queryCommentsWithUserCount(@Param("essayId") Integer essayId);

  List<TravelEssayComment> queryCommentIdsByEssayId(Integer essayId);

  int deleteEssayComment(Integer essayId);

  List<CommentWithUser> queryCommentsByUserId(@Param("userId") Integer userId);

	int queryEssayIdByCommentId(@Param("commentId") Integer commentId);

	List<CommentWithUser> queryWithContent(@Param("title") String title);

  void deleteEssayCommentAccording2CommentId(@Param("commentId") Integer id);
}
