package fixtures.clubs

import io.micronaut.http.client.annotation.Client

@Client("clubs-service")
interface ClubsClient extends ClubsApi {


}