.class Lnet/singular/sdk/ManifestHelper;
.super Ljava/lang/Object;
.source "ManifestHelper.java"


# instance fields
.field private final context:Landroid/content/Context;

.field private final log:Lnet/singular/sdk/SingularLog;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lnet/singular/sdk/SingularLog;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lnet/singular/sdk/ManifestHelper;->context:Landroid/content/Context;

    .line 15
    iput-object p2, p0, Lnet/singular/sdk/ManifestHelper;->log:Lnet/singular/sdk/SingularLog;

    .line 16
    return-void
.end method

.method private getApplicationMetadata()Landroid/os/Bundle;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 80
    :try_start_0
    iget-object v3, p0, Lnet/singular/sdk/ManifestHelper;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    .line 81
    .local v2, "packageName":Ljava/lang/String;
    iget-object v3, p0, Lnet/singular/sdk/ManifestHelper;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const/16 v4, 0x80

    invoke-virtual {v3, v2, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 82
    .local v0, "applicationInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v3, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    return-object v3

    .line 83
    .end local v0    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "packageName":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 84
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    iget-object v3, p0, Lnet/singular/sdk/ManifestHelper;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "ApplicationInfo not found"

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    throw v1

    .line 86
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v1

    .line 87
    .local v1, "e":Ljava/lang/Exception;
    iget-object v3, p0, Lnet/singular/sdk/ManifestHelper;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "Failed to get ApplicationBundle (%s)"

    invoke-virtual {v3, v4, v5, v1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 88
    throw v1
.end method


# virtual methods
.method public getManifestAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 9
    .param p1, "manifestKey"    # Ljava/lang/String;
    .param p2, "valueName"    # Ljava/lang/String;
    .param p3, "funcName"    # Ljava/lang/String;
    .param p4, "notifyWhenMissing"    # Z

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 20
    :try_start_0
    invoke-direct {p0}, Lnet/singular/sdk/ManifestHelper;->getApplicationMetadata()Landroid/os/Bundle;

    move-result-object v0

    .line 21
    .local v0, "applicationMetadata":Landroid/os/Bundle;
    invoke-virtual {v0, p1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 22
    .local v2, "value":Ljava/lang/Object;
    if-eqz v2, :cond_0

    .line 23
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 36
    .end local v0    # "applicationMetadata":Landroid/os/Bundle;
    .end local v2    # "value":Ljava/lang/Object;
    :goto_0
    return-object v3

    .line 26
    :catch_0
    move-exception v1

    .line 27
    .local v1, "e":Ljava/lang/Exception;
    iget-object v3, p0, Lnet/singular/sdk/ManifestHelper;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "%s: getManifestAttribute: something went wrong"

    new-array v6, v8, [Ljava/lang/Object;

    aput-object p3, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5, v1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 30
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_0
    if-eqz p4, :cond_1

    .line 32
    const-string v3, "singular_sdk"

    const-string v4, "Couldn\'t read %s, you must set a metadata tag named \"%s\" in your AndroidManifest.xml file"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p2, v5, v7

    aput-object p1, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 36
    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public tryToGetManifestAttributeBool(Ljava/lang/String;Z)Z
    .locals 8
    .param p1, "manifestKey"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Z

    .prologue
    const/4 v7, 0x0

    .line 64
    const-string v3, "tryToGetManifestAttributeBool"

    invoke-virtual {p0, p1, p1, v3, v7}, Lnet/singular/sdk/ManifestHelper;->getManifestAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v2

    .line 66
    .local v2, "value_string":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 68
    :try_start_0
    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 69
    .local v1, "ret":Ljava/lang/Boolean;
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result p2

    .line 75
    .end local v1    # "ret":Ljava/lang/Boolean;
    .end local p2    # "defaultValue":Z
    :cond_0
    :goto_0
    return p2

    .line 70
    .restart local p2    # "defaultValue":Z
    :catch_0
    move-exception v0

    .line 71
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v3, p0, Lnet/singular/sdk/ManifestHelper;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "Couldn\'t parse \"%s\" value \"%s\" in your AndroidManifest.xml file"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    aput-object p1, v6, v7

    const/4 v7, 0x1

    aput-object v2, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public tryToGetManifestAttributeLong(Ljava/lang/String;J)J
    .locals 2
    .param p1, "manifestKey"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 55
    invoke-virtual {p0, p1}, Lnet/singular/sdk/ManifestHelper;->tryToGetManifestAttributeLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    .line 56
    .local v0, "value":Ljava/lang/Long;
    if-eqz v0, :cond_0

    .line 57
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide p2

    .line 59
    .end local p2    # "defaultValue":J
    :cond_0
    return-wide p2
.end method

.method public tryToGetManifestAttributeLong(Ljava/lang/String;)Ljava/lang/Long;
    .locals 7
    .param p1, "manifestKey"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 40
    const-string v3, "tryToGetManifestAttributeLong"

    invoke-virtual {p0, p1, p1, v3, v6}, Lnet/singular/sdk/ManifestHelper;->getManifestAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v2

    .line 42
    .local v2, "value_string":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 44
    :try_start_0
    invoke-static {v2}, Ljava/lang/Long;->decode(Ljava/lang/String;)Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 51
    :goto_0
    return-object v1

    .line 46
    :catch_0
    move-exception v0

    .line 47
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v3, "singular_sdk"

    const-string v4, "Couldn\'t parse \"%s\" value \"%s\" in your AndroidManifest.xml file"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    const/4 v6, 0x1

    aput-object v2, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
