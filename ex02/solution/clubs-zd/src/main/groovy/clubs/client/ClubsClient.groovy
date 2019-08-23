package clubs.client

import clubs.api.ClubsApi
import io.micronaut.http.client.annotation.Client

@Client("/")
interface ClubsClient extends ClubsApi{

}
