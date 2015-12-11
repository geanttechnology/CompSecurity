.class public Lcom/poshmark/user/UserInfoDetails;
.super Ljava/lang/Object;
.source "UserInfoDetails.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/user/UserInfoDetails$EmailSettings;,
        Lcom/poshmark/user/UserInfoDetails$Notifications;,
        Lcom/poshmark/user/UserInfoDetails$PasswordStatus;,
        Lcom/poshmark/user/UserInfoDetails$Settings;,
        Lcom/poshmark/user/UserInfoDetails$AB_Segment;
    }
.end annotation


# static fields
.field public static final USER_ROLE_ADMIN:Ljava/lang/String; = "admin"

.field public static final USER_ROLE_EVENT_CREATOR:Ljava/lang/String; = "event_creator"

.field public static final USER_ROLE_EVENT_HOST:Ljava/lang/String; = "event_host"

.field public static final USER_ROLE_MODERATOR:Ljava/lang/String; = "moderator"


# instance fields
.field private ab_segment:Lcom/poshmark/user/UserInfoDetails$AB_Segment;

.field private aggregates:Lcom/poshmark/data_model/models/inner_models/UserAggregates;

.field private blocked:Z

.field private caller_is_following:Z

.field private cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

.field private created_at:Ljava/lang/String;

.field private devices:[Ljava/lang/String;

.field private display_handle:Ljava/lang/String;

.field private display_status:Ljava/lang/String;

.field private email:Ljava/lang/String;

.field private fb_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

.field private fb_user_id:Ljava/lang/String;

.field private first_name:Ljava/lang/String;

.field private full_name:Ljava/lang/String;

.field private gp_user_id:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private last_name:Ljava/lang/String;

.field private last_viewed_notification:Ljava/lang/String;

.field private last_viewed_notification_number:I

.field private last_viewed_notification_time:Ljava/lang/String;

.field private pn_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

.field private profile:Lcom/poshmark/data_model/models/inner_models/Profile;

.field private reg_app:Ljava/lang/String;

.field private reg_method:Ljava/lang/String;

.field private roles:[Ljava/lang/String;

.field private search_visibility:Z

.field private settings:Lcom/poshmark/user/UserInfoDetails$Settings;

.field private status:Ljava/lang/String;

.field private tm_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

.field private tw_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

.field private username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/user/UserInfoDetails;->blocked:Z

    .line 270
    return-void
.end method


# virtual methods
.method public canPerformActionForRole(Ljava/lang/String;)Z
    .locals 5
    .param p1, "role"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 215
    iget-object v4, p0, Lcom/poshmark/user/UserInfoDetails;->roles:[Ljava/lang/String;

    if-nez v4, :cond_1

    .line 225
    :cond_0
    :goto_0
    return v3

    .line 218
    :cond_1
    iget-object v4, p0, Lcom/poshmark/user/UserInfoDetails;->roles:[Ljava/lang/String;

    array-length v1, v4

    .line 219
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_0

    .line 220
    iget-object v4, p0, Lcom/poshmark/user/UserInfoDetails;->roles:[Ljava/lang/String;

    aget-object v2, v4, v0

    .line 221
    .local v2, "r":Ljava/lang/String;
    invoke-virtual {v2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 222
    const/4 v3, 0x1

    goto :goto_0

    .line 219
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public getABSegment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->ab_segment:Lcom/poshmark/user/UserInfoDetails$AB_Segment;

    if-eqz v0, :cond_0

    .line 235
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->ab_segment:Lcom/poshmark/user/UserInfoDetails$AB_Segment;

    iget-object v0, v0, Lcom/poshmark/user/UserInfoDetails$AB_Segment;->sign_up:Ljava/lang/String;

    .line 237
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getClosetTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 129
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/poshmark/user/UserInfoDetails;->first_name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'s Closet"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getClosetURL()Ljava/lang/String;
    .locals 5

    .prologue
    .line 229
    const-string v0, "https://www.poshmark.com"

    .line 230
    .local v0, "baseURL":Ljava/lang/String;
    const-string v1, "%s/closet/%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/poshmark/user/UserInfoDetails;->id:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    return-object v0
.end method

.method public getDisplayHandle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->display_handle:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->display_status:Ljava/lang/String;

    return-object v0
.end method

.method public getFbInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->fb_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

    return-object v0
.end method

.method public getFbUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->fb_user_id:Ljava/lang/String;

    return-object v0
.end method

.method public getFollowersCount()I
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->aggregates:Lcom/poshmark/data_model/models/inner_models/UserAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/UserAggregates;->followers:I

    return v0
.end method

.method public getFollowingCount()I
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->aggregates:Lcom/poshmark/data_model/models/inner_models/UserAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/UserAggregates;->following:I

    return v0
.end method

.method public getGPInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 1

    .prologue
    .line 174
    const/4 v0, 0x0

    return-object v0
.end method

.method public getGoogleUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->gp_user_id:Ljava/lang/String;

    return-object v0
.end method

.method public getListingCount()I
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->aggregates:Lcom/poshmark/data_model/models/inner_models/UserAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/UserAggregates;->posts:I

    return v0
.end method

.method public getPMUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getPnInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->pn_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

    return-object v0
.end method

.method public getPostToTimelineFlag()Z
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->settings:Lcom/poshmark/user/UserInfoDetails$Settings;

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->settings:Lcom/poshmark/user/UserInfoDetails$Settings;

    iget-boolean v0, v0, Lcom/poshmark/user/UserInfoDetails$Settings;->timeline:Z

    .line 190
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getProfile()Lcom/poshmark/data_model/models/inner_models/Profile;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->profile:Lcom/poshmark/data_model/models/inner_models/Profile;

    return-object v0
.end method

.method public getRoles()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->roles:[Ljava/lang/String;

    return-object v0
.end method

.method public getSearchVisibilityFlag()Z
    .locals 1

    .prologue
    .line 183
    iget-boolean v0, p0, Lcom/poshmark/user/UserInfoDetails;->search_visibility:Z

    return v0
.end method

.method public getShareCount()I
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->aggregates:Lcom/poshmark/data_model/models/inner_models/UserAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/UserAggregates;->shares:I

    return v0
.end method

.method public getTumblrInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->tm_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

    return-object v0
.end method

.method public getTwitterInfo()Lcom/poshmark/data_model/models/ExternalServiceInfo;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->tw_info:Lcom/poshmark/data_model/models/ExternalServiceInfo;

    return-object v0
.end method

.method public getUserCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->profile:Lcom/poshmark/data_model/models/inner_models/Profile;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/Profile;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getUserDisplayHandle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->display_handle:Ljava/lang/String;

    return-object v0
.end method

.method public getUserDressSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->profile:Lcom/poshmark/data_model/models/inner_models/Profile;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/Profile;->dress_size:Ljava/lang/String;

    return-object v0
.end method

.method public getUserEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getUserFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->first_name:Ljava/lang/String;

    return-object v0
.end method

.method public getUserLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->last_name:Ljava/lang/String;

    return-object v0
.end method

.method public getUserLoginConnectionType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->reg_method:Ljava/lang/String;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->username:Ljava/lang/String;

    return-object v0
.end method

.method public getUserShoeSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->profile:Lcom/poshmark/data_model/models/inner_models/Profile;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/Profile;->shoe_size:Ljava/lang/String;

    return-object v0
.end method

.method public getUserSmallPicUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 125
    :goto_0
    return-object v0

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->fb_user_id:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->fb_user_id:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 120
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->fb_user_id:Ljava/lang/String;

    invoke-static {v0}, Lcom/poshmark/utils/FBUtils;->getUserFBImageURL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 121
    :cond_1
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->gp_user_id:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->gp_user_id:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_2

    .line 122
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->fb_user_id:Ljava/lang/String;

    invoke-static {v0}, Lcom/poshmark/utils/FBUtils;->getUserFBImageURL(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 125
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getUserState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->profile:Lcom/poshmark/data_model/models/inner_models/Profile;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/Profile;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getUserWebsite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->profile:Lcom/poshmark/data_model/models/inner_models/Profile;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/Profile;->website:Ljava/lang/String;

    return-object v0
.end method

.method public isCallerFollowing()Z
    .locals 1

    .prologue
    .line 154
    iget-boolean v0, p0, Lcom/poshmark/user/UserInfoDetails;->caller_is_following:Z

    return v0
.end method

.method public isUserBlocked()Z
    .locals 1

    .prologue
    .line 195
    iget-boolean v0, p0, Lcom/poshmark/user/UserInfoDetails;->blocked:Z

    return v0
.end method

.method public setBlockedFlag(Z)V
    .locals 0
    .param p1, "flag"    # Z

    .prologue
    .line 199
    iput-boolean p1, p0, Lcom/poshmark/user/UserInfoDetails;->blocked:Z

    .line 200
    return-void
.end method

.method public setCallerIsFollowing(Z)V
    .locals 0
    .param p1, "following"    # Z

    .prologue
    .line 203
    iput-boolean p1, p0, Lcom/poshmark/user/UserInfoDetails;->caller_is_following:Z

    .line 204
    return-void
.end method

.method public setFollowersCount(I)V
    .locals 1
    .param p1, "count"    # I

    .prologue
    .line 137
    iget-object v0, p0, Lcom/poshmark/user/UserInfoDetails;->aggregates:Lcom/poshmark/data_model/models/inner_models/UserAggregates;

    iput p1, v0, Lcom/poshmark/data_model/models/inner_models/UserAggregates;->followers:I

    .line 138
    return-void
.end method
