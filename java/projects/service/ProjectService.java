package projects.service;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {

	private ProjectDao projectDao = new ProjectDao();
	
	

			
	public Project addProject(Project project) {
		
		return projectDao.insertProject(project);
	}




	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects(); 
	}




	public Project fetchProjectById(Integer projectId) {
		return projectDao.fetchProjectById(projectId).orElseThrow(
				() -> new NoSuchElementException( "Project with project ID= " + projectId + " is an invalid Project Id."));
	
		
	}

	// calls the DAO to check if the UPDATE was successful. If project cannot be found, it throws an exception 

	public void modifyProjectDetails(Project project) {
		
		if(!projectDao.modifyProjectDaoDetails(project)) {
			throw new DbException("Project with ID=" + project.getProjectId() + " does not exist. ");
			
		}
		
	}




	public void deleteProject(Integer projectId) {

		if(!projectDao.deleteProject(projectId)){
		
		throw new DbException("Project with ID=" + projectId + " does not exist.");
		
	}

	}

}
	


		
	


	

