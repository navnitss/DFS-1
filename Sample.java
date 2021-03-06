// Time Complexity :O(n)
// Space Complexity :O(n)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] result=new int[m][n];
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                    q.add(new int[]{i,j});
            }
        }
        int level=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] src=q.poll();
                for(int[] dir:dirs)
                {
                    int r=src[0]+dir[0];
                    int c=src[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c]==1)
                    {
                        System.out.println(r+" "+c);
                        q.add(new int[]{r,c});
                        matrix[r][c]=level*(-1);
                    }
                }
            }
            level++;
        }
        for(int i=0;i<m;i++)
           for(int j=0;j<n;j++)
            {
                    if(matrix[i][j]<0)
                        matrix[i][j]=matrix[i][j]*(-1);
            }
        return matrix;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------
// Time Complexity :O(n)
// Space Complexity :O(n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}