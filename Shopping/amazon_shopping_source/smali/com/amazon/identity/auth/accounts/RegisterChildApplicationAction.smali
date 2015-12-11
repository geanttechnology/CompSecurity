.class public Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;
.super Ljava/lang/Object;
.source "RegisterChildApplicationAction.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;,
        Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$NotChildApplicationException;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mPendingRegisterRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

.field private final mPendingUpdateRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mContext:Landroid/content/Context;

    .line 69
    new-instance v0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mPendingRegisterRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    .line 70
    new-instance v0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mPendingUpdateRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    .line 71
    return-void
.end method

.method private getPackageVersionForDeviceType(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;
    .locals 10
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 153
    iget-object v7, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mContext:Landroid/content/Context;

    invoke-static {v7}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAllMapApplication()Ljava/util/Collection;

    move-result-object v6

    .line 156
    .local v6, "remoteMapApps":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    const/4 v3, 0x0

    .line 157
    .local v3, "largestCurrentPackageVersion":Ljava/lang/Integer;
    const/4 v0, 0x0

    .line 158
    .local v0, "currentPackageName":Ljava/lang/String;
    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 162
    .local v5, "remoteMapApp":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :try_start_0
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 164
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageVersion()Ljava/lang/Integer;

    move-result-object v4

    .line 165
    .local v4, "packageVersion":Ljava/lang/Integer;
    if-eqz v4, :cond_0

    .line 170
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v7

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v8

    if-ge v7, v8, :cond_0

    .line 172
    :cond_1
    move-object v3, v4

    .line 173
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 177
    .end local v4    # "packageVersion":Ljava/lang/Integer;
    :catch_0
    move-exception v1

    .line 181
    .local v1, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v7, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Couldn\'t determine device type for "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 185
    .end local v1    # "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    .end local v5    # "remoteMapApp":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    :cond_2
    new-instance v7, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    invoke-direct {v7, v3, v0}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;-><init>(Ljava/lang/Integer;Ljava/lang/String;)V

    return-object v7
.end method


# virtual methods
.method public registerChildApplication(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 13
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "givenOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$NotChildApplicationException;
        }
    .end annotation

    .prologue
    .line 79
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mContext:Landroid/content/Context;

    invoke-static {v8, p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplication(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 81
    new-instance v8, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$NotChildApplicationException;

    invoke-direct {v8}, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$NotChildApplicationException;-><init>()V

    throw v8

    .line 84
    :cond_0
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mPendingRegisterRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    move-object/from16 v0, p4

    invoke-virtual {v8, p2, v0}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->waitForInflightRequestOrMakeRequest(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v1

    .line 86
    .local v1, "newRequestCallback":Lcom/amazon/identity/auth/device/api/Callback;
    if-nez v1, :cond_1

    .line 88
    sget-object v8, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Register child app request already in flight for device type %s"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object p2, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :goto_0
    return-void

    .line 92
    :cond_1
    new-instance v7, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;

    invoke-direct {v7, v1}, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 94
    .local v7, "wrappedCallback":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    invoke-static/range {p3 .. p3}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->constructEmptyBundleIfNull(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v2

    .line 95
    .local v2, "options":Landroid/os/Bundle;
    const-string/jumbo v8, "override_dsn"

    invoke-virtual {v2, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 97
    .local v3, "overrideDsn":Ljava/lang/String;
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->getPackageVersionForDeviceType(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    move-result-object v4

    .line 98
    .local v4, "packageInfo":Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;
    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareVersion()Ljava/lang/Integer;

    move-result-object v6

    .line 99
    .local v6, "packageVersion":Ljava/lang/Integer;
    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareComponentId()Ljava/lang/String;

    move-result-object v5

    .line 100
    .local v5, "packageName":Ljava/lang/String;
    sget-object v9, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Registering child application with device type %s, version %s, and component id %s"

    const/4 v8, 0x3

    new-array v11, v8, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p2, v11, v8

    const/4 v12, 0x1

    if-eqz v6, :cond_2

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    :goto_1
    aput-object v8, v11, v12

    const/4 v8, 0x2

    aput-object v5, v11, v8

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v9, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mContext:Landroid/content/Context;

    invoke-static {v8, p2, v3, v6, v5}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->constructDMSSubAuthForDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    move-result-object v8

    .line 112
    move-object/from16 v0, p5

    invoke-virtual {v8, v7, p1, v2, v0}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->registerChildApplication(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 100
    :cond_2
    const-string/jumbo v8, "None"

    goto :goto_1
.end method

.method public updateChildApplicationCredentials(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 13
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "givenOptions"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 121
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mPendingUpdateRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    move-object/from16 v0, p4

    invoke-virtual {v8, p2, v0}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->waitForInflightRequestOrMakeRequest(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v1

    .line 123
    .local v1, "newRequestCallback":Lcom/amazon/identity/auth/device/api/Callback;
    if-nez v1, :cond_0

    .line 125
    sget-object v8, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Update child app request already in flight for device type %s"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object p2, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    :goto_0
    return-void

    .line 129
    :cond_0
    new-instance v7, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;

    invoke-direct {v7, v1}, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction$SubAuthenticatorCallbackAdapter;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 131
    .local v7, "wrappedCallback":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    invoke-static/range {p3 .. p3}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->constructEmptyBundleIfNull(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v2

    .line 132
    .local v2, "options":Landroid/os/Bundle;
    const-string/jumbo v8, "override_dsn"

    invoke-virtual {v2, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 134
    .local v3, "overrideDsn":Ljava/lang/String;
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->getPackageVersionForDeviceType(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    move-result-object v4

    .line 135
    .local v4, "packageInfo":Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;
    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareVersion()Ljava/lang/Integer;

    move-result-object v6

    .line 136
    .local v6, "packageVersion":Ljava/lang/Integer;
    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareComponentId()Ljava/lang/String;

    move-result-object v5

    .line 137
    .local v5, "packageName":Ljava/lang/String;
    sget-object v9, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Updating child application with device type %s, version %s, and component id %s"

    const/4 v8, 0x3

    new-array v11, v8, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p2, v11, v8

    const/4 v12, 0x1

    if-eqz v6, :cond_1

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    :goto_1
    aput-object v8, v11, v12

    const/4 v8, 0x2

    aput-object v5, v11, v8

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v9, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/RegisterChildApplicationAction;->mContext:Landroid/content/Context;

    invoke-static {v8, p2, v3, v6, v5}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->constructDMSSubAuthForDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    move-result-object v8

    .line 148
    move-object/from16 v0, p5

    invoke-virtual {v8, v7, p1, v2, v0}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->updateCredentials(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 137
    :cond_1
    const-string/jumbo v8, "None"

    goto :goto_1
.end method
