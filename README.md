# Finra-Task
Finra API Task to upload files along with its metadata

This API is for users uploading files to an the server 
And push metadata of files to in-memory database (I chose derby)

The metadata I stored includes file_name, file_path, upload_time.

We can upload files with verb POST
We can get all uploaded files' metadata with verb GET
We can get specific file's metadata by its file_id with verb GET
Also handle the invalid id input exception if the id doesn't exist in database
