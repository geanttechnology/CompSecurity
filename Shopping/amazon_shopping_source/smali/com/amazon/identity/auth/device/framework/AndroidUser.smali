.class public final Lcom/amazon/identity/auth/device/framework/AndroidUser;
.super Ljava/lang/Object;
.source "AndroidUser.java"


# static fields
.field public static final DEFAULT_OWNER_ID:I

.field private static final OWNER_ID:Ljava/lang/Integer;

.field private static final TAG:Ljava/lang/String;

.field public static final USER_HANDLE_CLASS:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# instance fields
.field private final mAndroidUserHandle:Landroid/os/UserHandle;

.field private final mFlags:I

.field private final mUserHandleId:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getUserHandleClass()Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->USER_HANDLE_CLASS:Ljava/lang/Class;

    .line 17
    const-class v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    .line 19
    sget-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->USER_HANDLE_CLASS:Ljava/lang/Class;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getOwnerId(Ljava/lang/Class;)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->OWNER_ID:Ljava/lang/Integer;

    return-void
.end method

.method constructor <init>(IILjava/lang/Object;)V
    .locals 0
    .param p1, "userHandleId"    # I
    .param p2, "flags"    # I
    .param p3, "userHandle"    # Ljava/lang/Object;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput p1, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mUserHandleId:I

    .line 36
    iput p2, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mFlags:I

    .line 37
    check-cast p3, Landroid/os/UserHandle;

    .end local p3    # "userHandle":Ljava/lang/Object;
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mAndroidUserHandle:Landroid/os/UserHandle;

    .line 38
    return-void
.end method

.method public static convertFromUserInfo(Ljava/lang/Object;)Lcom/amazon/identity/auth/device/framework/AndroidUser;
    .locals 9
    .param p0, "userInfo"    # Ljava/lang/Object;

    .prologue
    const/4 v6, 0x0

    .line 159
    if-eqz p0, :cond_0

    const-string/jumbo v5, "android.content.pm.UserInfo"

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 161
    :cond_0
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Given Object is not a valid UserInfo class"

    invoke-static {v5, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v6

    .line 180
    :goto_0
    return-object v5

    .line 167
    :cond_1
    :try_start_0
    new-instance v3, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v3}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    .line 169
    .local v3, "refHelper":Lcom/amazon/identity/auth/device/utils/ReflectionHelper;
    const-string/jumbo v5, "id"

    invoke-virtual {v3, p0, v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getField(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 170
    .local v2, "id":I
    const-string/jumbo v5, "flags"

    invoke-virtual {v3, p0, v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getField(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 171
    .local v1, "flags":I
    const-string/jumbo v5, "getUserHandle"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/Object;

    invoke-virtual {v3, v5, p0, v7, v8}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 173
    .local v4, "userHandle":Ljava/lang/Object;
    new-instance v5, Lcom/amazon/identity/auth/device/framework/AndroidUser;

    invoke-direct {v5, v2, v1, v4}, Lcom/amazon/identity/auth/device/framework/AndroidUser;-><init>(IILjava/lang/Object;)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 175
    .end local v1    # "flags":I
    .end local v2    # "id":I
    .end local v3    # "refHelper":Lcom/amazon/identity/auth/device/utils/ReflectionHelper;
    .end local v4    # "userHandle":Ljava/lang/Object;
    :catch_0
    move-exception v0

    .line 177
    .local v0, "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Cannot construct Android User from User Info"

    invoke-static {v5, v7, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v5, v6

    .line 180
    goto :goto_0
.end method

.method public static getCallingUserId()I
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 72
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->USER_HANDLE_CLASS:Ljava/lang/Class;

    if-nez v1, :cond_0

    move v1, v2

    .line 87
    .local v0, "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    :goto_0
    return v1

    .line 79
    .end local v0    # "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    :cond_0
    :try_start_0
    new-instance v1, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    .line 80
    const-string/jumbo v3, "getCallingUserId"

    const-string/jumbo v4, "android.os.UserHandle"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v1, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    goto :goto_0

    .line 82
    :catch_0
    move-exception v0

    .line 84
    .restart local v0    # "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot get getCallingUserId static field. Error: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v1, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move v1, v2

    .line 87
    goto :goto_0
.end method

.method public static getCurrentUserId()I
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 94
    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    .line 95
    const-string/jumbo v2, "getCurrentUser"

    const-class v3, Landroid/app/ActivityManager;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invokeStatic(Ljava/lang/String;Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 102
    :goto_0
    return v0

    .line 99
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    move v0, v1

    .line 102
    goto :goto_0
.end method

.method public static getMyUserId()I
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 52
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->USER_HANDLE_CLASS:Ljava/lang/Class;

    if-nez v1, :cond_0

    move v1, v2

    .line 67
    .local v0, "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    :goto_0
    return v1

    .line 59
    .end local v0    # "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    :cond_0
    :try_start_0
    new-instance v1, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    .line 60
    const-string/jumbo v3, "myUserId"

    const-string/jumbo v4, "android.os.UserHandle"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v1, v3, v4, v5, v6}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    goto :goto_0

    .line 62
    :catch_0
    move-exception v0

    .line 64
    .restart local v0    # "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot get myUserId static field. Error: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v1, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move v1, v2

    .line 67
    goto :goto_0
.end method

.method public static getOwnerId()I
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->OWNER_ID:Ljava/lang/Integer;

    if-nez v0, :cond_0

    .line 44
    const/4 v0, 0x0

    .line 47
    :goto_0
    return v0

    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->OWNER_ID:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_0
.end method

.method private static getOwnerId(Ljava/lang/Class;)Ljava/lang/Integer;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/Integer;"
        }
    .end annotation

    .prologue
    .local p0, "userHandleClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v2, 0x0

    .line 199
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->USER_HANDLE_CLASS:Ljava/lang/Class;

    if-nez v1, :cond_0

    .line 201
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    move-object v1, v2

    .line 215
    :goto_0
    return-object v1

    .line 207
    :cond_0
    :try_start_0
    new-instance v1, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    .line 208
    const-string/jumbo v3, "USER_OWNER"

    invoke-virtual {v1, p0, v3}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getStaticField(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 210
    :catch_0
    move-exception v0

    .line 212
    .local v0, "e":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot get USER_OWNER static field. Error: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$CannotCallMethodException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v1, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move-object v1, v2

    .line 215
    goto :goto_0
.end method

.method private static getUserHandleClass()Ljava/lang/Class;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 187
    :try_start_0
    const-string/jumbo v0, "android.os.UserHandle"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 194
    :goto_0
    return-object v0

    .line 191
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->TAG:Ljava/lang/String;

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    const-string/jumbo v2, "android.os.UserHandle"

    aput-object v2, v0, v1

    .line 194
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "otherObj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 147
    if-eqz p1, :cond_0

    instance-of v2, p1, Lcom/amazon/identity/auth/device/framework/AndroidUser;

    if-nez v2, :cond_1

    .line 154
    :cond_0
    :goto_0
    return v1

    :cond_1
    move-object v0, p1

    .line 152
    check-cast v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;

    .line 154
    .local v0, "otherAndroidUser":Lcom/amazon/identity/auth/device/framework/AndroidUser;
    iget v2, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mUserHandleId:I

    iget v3, v0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mUserHandleId:I

    if-ne v2, v3, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public getUserHandle()Landroid/os/UserHandle;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mAndroidUserHandle:Landroid/os/UserHandle;

    return-object v0
.end method

.method public getUserId()I
    .locals 1

    .prologue
    .line 107
    iget v0, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mUserHandleId:I

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 138
    iget v0, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mUserHandleId:I

    add-int/lit8 v0, v0, 0x1f

    .line 141
    return v0
.end method

.method public isAdmin()Z
    .locals 2

    .prologue
    .line 122
    iget v0, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mFlags:I

    and-int/lit8 v0, v0, 0x2

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isGuest()Z
    .locals 2

    .prologue
    .line 127
    iget v0, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mFlags:I

    and-int/lit8 v0, v0, 0x4

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isOwner()Z
    .locals 2

    .prologue
    .line 132
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AndroidUser;->getOwnerId()I

    move-result v0

    iget v1, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mUserHandleId:I

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPrimary()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 117
    iget v1, p0, Lcom/amazon/identity/auth/device/framework/AndroidUser;->mFlags:I

    and-int/lit8 v1, v1, 0x1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
