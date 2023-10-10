import { API } from "./api"

export async function getLoginUser(
    email: string,
    senha: string
) {
    
    try {
        const response = await API.post(`/${email}${senha}`);
        return response.data;
    } catch (err) {
        throw new Error(err as string)
    }
}

export async function getRepositoryByUser(
    user: string
) {
    try {
        const response = await API.get(`/${user}/repos`);
        return response.data;
    } catch (err) {
        throw new Error(err as string)
    }
}