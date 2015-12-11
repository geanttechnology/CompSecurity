.class public Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;
.super Ljava/lang/Object;
.source "SubAuthenticatorRegistry.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDescriptionParser:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;

.field private final mGuard:Ljava/lang/Object;

.field private final mMapInformationQueryer:Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

.field private mSubAuthenticators:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;"
        }
    .end annotation
.end field

.field private mSubAuthenticatorsVersion:I

.field private final mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 60
    new-instance v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;

    invoke-direct {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;-><init>()V

    new-instance v1, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-direct {v1, p1}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;-><init>(Landroid/content/Context;)V

    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;)V

    .line 63
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;)V
    .locals 2
    .param p1, "parser"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;
    .param p2, "trustedPackageManager"    # Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;
    .param p3, "mapInformationQueryer"    # Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    .prologue
    const/4 v1, 0x0

    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-array v0, v1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mGuard:Ljava/lang/Object;

    .line 34
    iput v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticatorsVersion:I

    .line 70
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    .line 71
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mMapInformationQueryer:Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    .line 72
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mDescriptionParser:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;

    .line 73
    return-void
.end method

.method private getAppsWithSubAuthenticator()Ljava/util/List;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 144
    .local v10, "subAuthenticators":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    new-instance v9, Landroid/content/Intent;

    const-string/jumbo v12, "com.amazon.dcp.sso.AccountSubAuthenticator"

    invoke-direct {v9, v12}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 150
    .local v9, "subAuthenticatorIntent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    const/16 v13, 0x80

    invoke-virtual {v12, v9, v13}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v12

    .line 153
    invoke-interface {v12}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ResolveInfo;

    .line 157
    .local v7, "service":Landroid/content/pm/ResolveInfo;
    :try_start_0
    iget-object v4, v7, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    .line 159
    .local v4, "itemInfo":Landroid/content/pm/PackageItemInfo;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    const-string/jumbo v13, "com.amazon.dcp.sso.AccountSubAuthenticator"

    invoke-virtual {v12, v4, v13}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getParserForPackage(Landroid/content/pm/PackageItemInfo;Ljava/lang/String;)Landroid/content/res/XmlResourceParser;

    move-result-object v6

    .line 162
    .local v6, "parser":Landroid/content/res/XmlResourceParser;
    if-nez v6, :cond_1

    .line 164
    const-string/jumbo v12, "%s does not have a valid sub authenticator metadata file"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    iget-object v15, v4, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 166
    .local v5, "msg":Ljava/lang/String;
    new-instance v12, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v12, v5}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>(Ljava/lang/String;)V

    throw v12
    :try_end_0
    .catch Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException; {:try_start_0 .. :try_end_0} :catch_0

    .line 183
    .end local v4    # "itemInfo":Landroid/content/pm/PackageItemInfo;
    .end local v5    # "msg":Ljava/lang/String;
    .end local v6    # "parser":Landroid/content/res/XmlResourceParser;
    :catch_0
    move-exception v1

    .line 185
    .local v1, "e":Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
    sget-object v12, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v13, "Ignored invalid sub authenticator from package %s: %s"

    const/4 v14, 0x2

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    iget-object v0, v7, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    move-object/from16 v16, v0

    aput-object v16, v14, v15

    const/4 v15, 0x1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;->toString()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-static {v13, v14}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 169
    .end local v1    # "e":Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
    .restart local v4    # "itemInfo":Landroid/content/pm/PackageItemInfo;
    .restart local v6    # "parser":Landroid/content/res/XmlResourceParser;
    :cond_1
    :try_start_1
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mDescriptionParser:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;

    iget-object v13, v4, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    iget-object v14, v4, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v12, v13, v14, v6}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;->parse(Ljava/lang/String;Ljava/lang/String;Landroid/content/res/XmlResourceParser;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    move-result-object v8

    .line 172
    .local v8, "subAuth":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    invoke-interface {v10, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 174
    sget-object v12, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v12, "Detected sub-authenticator: %s/%s"

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    iget-object v15, v8, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v15, v13, v14

    const/4 v14, 0x1

    iget-object v15, v8, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->className:Ljava/lang/String;

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 176
    sget-object v12, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v12, " Supports token types:"

    const/4 v13, 0x0

    new-array v13, v13, [Ljava/lang/Object;

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 177
    iget-object v12, v8, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->tokenTypes:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 179
    .local v11, "tokenType":Ljava/lang/String;
    sget-object v12, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v12, "  %s"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object v11, v13, v14

    invoke-static {v12, v13}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_1
    .catch Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 190
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "itemInfo":Landroid/content/pm/PackageItemInfo;
    .end local v6    # "parser":Landroid/content/res/XmlResourceParser;
    .end local v7    # "service":Landroid/content/pm/ResolveInfo;
    .end local v8    # "subAuth":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .end local v11    # "tokenType":Ljava/lang/String;
    :cond_2
    return-object v10
.end method

.method private getDMSApps()Ljava/util/List;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;"
        }
    .end annotation

    .prologue
    .line 195
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 196
    .local v7, "subAuthenticators":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->getDmsPackageInfos()Ljava/util/List;

    move-result-object v9

    .line 198
    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;

    .line 201
    .local v0, "dmsPackage":Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 202
    .local v4, "packageName":Ljava/lang/String;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;->getParser()Landroid/content/res/XmlResourceParser;

    move-result-object v5

    .line 206
    .local v5, "parser":Landroid/content/res/XmlResourceParser;
    :try_start_0
    iget-object v9, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mDescriptionParser:Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;

    const/4 v10, 0x0

    invoke-virtual {v9, v4, v10, v5}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescriptionParser;->parse(Ljava/lang/String;Ljava/lang/String;Landroid/content/res/XmlResourceParser;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    move-result-object v6

    .line 207
    .local v6, "subAuth":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 208
    sget-object v9, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Detected DMS sub-authenticator: %s/%s"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    iget-object v12, v6, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v12, v10, v11

    const/4 v11, 0x1

    iget-object v12, v6, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->className:Ljava/lang/String;

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 210
    sget-object v9, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v9, " Supports token types:"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 211
    iget-object v9, v6, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->tokenTypes:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 213
    .local v8, "tokenType":Ljava/lang/String;
    sget-object v9, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "  %s"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v8, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 217
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v6    # "subAuth":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .end local v8    # "tokenType":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 219
    .local v1, "e":Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
    sget-object v9, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Ignored invalid sub authenticator from package %s: %s"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v4, v11, v12

    const/4 v12, 0x1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;->toString()Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 225
    .end local v0    # "dmsPackage":Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;
    .end local v1    # "e":Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
    .end local v4    # "packageName":Ljava/lang/String;
    .end local v5    # "parser":Landroid/content/res/XmlResourceParser;
    :cond_1
    return-object v7
.end method

.method private getDmsPackageInfos()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 242
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getTrustedInstalledPackages()Ljava/util/Set;

    move-result-object v7

    .line 243
    .local v7, "trustedInstalledPackages":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 246
    .local v2, "dmsPackages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;>;"
    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 250
    .local v5, "packageName":Ljava/lang/String;
    :try_start_0
    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    invoke-virtual {v8, v5}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->getResourcesForApplication(Ljava/lang/String;)Landroid/content/res/Resources;

    move-result-object v0

    .line 252
    .local v0, "appResources":Landroid/content/res/Resources;
    if-eqz v0, :cond_0

    .line 256
    const-string/jumbo v8, "dms_sub_authenticator"

    const-string/jumbo v9, "xml"

    invoke-virtual {v0, v8, v9, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    .line 260
    .local v4, "identifier":I
    if-eqz v4, :cond_0

    .line 262
    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v6

    .line 263
    .local v6, "parser":Landroid/content/res/XmlResourceParser;
    new-instance v1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;

    invoke-direct {v1, v5, v6}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;-><init>(Ljava/lang/String;Landroid/content/res/XmlResourceParser;)V

    .line 264
    .local v1, "dmsPackage":Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 269
    .end local v0    # "appResources":Landroid/content/res/Resources;
    .end local v1    # "dmsPackage":Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry$DMSPackageInfo;
    .end local v4    # "identifier":I
    .end local v6    # "parser":Landroid/content/res/XmlResourceParser;
    :catch_0
    move-exception v8

    sget-object v8, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Cannot get resources for applicatoin. "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " not found"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_0

    .line 272
    .end local v5    # "packageName":Ljava/lang/String;
    :cond_1
    return-object v2
.end method

.method private getSubAuthenticatorList()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mGuard:Ljava/lang/Object;

    monitor-enter v6

    .line 112
    :try_start_0
    iget v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticatorsVersion:I

    .line 113
    .local v1, "authenticatorsVersion":I
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticators:Ljava/util/List;

    if-eqz v5, :cond_0

    .line 115
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticators:Ljava/util/List;

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 138
    :goto_0
    return-object v4

    .line 117
    :cond_0
    monitor-exit v6

    .line 120
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->getAppsWithSubAuthenticator()Ljava/util/List;

    move-result-object v0

    .line 121
    .local v0, "appsWithSubAuthenticator":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->getDMSApps()Ljava/util/List;

    move-result-object v3

    .line 122
    .local v3, "dmsApps":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    new-instance v6, Ljava/util/HashSet;

    invoke-direct {v6}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v8, v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v6, v8}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 117
    .end local v0    # "appsWithSubAuthenticator":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    .end local v1    # "authenticatorsVersion":I
    .end local v3    # "dmsApps":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5

    .line 122
    .restart local v0    # "appsWithSubAuthenticator":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    .restart local v1    # "authenticatorsVersion":I
    .restart local v3    # "dmsApps":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    :cond_1
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    iget-object v8, v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v6, v8}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_2

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    :cond_2
    sget-object v8, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Deduped sub-authenticator"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, v5, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_2

    .line 125
    .local v2, "dedupedSubAuthenticators":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    :cond_3
    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->removeMAPR5Applications(Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    .line 127
    invoke-static {v5}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v4

    .line 129
    .local v4, "result":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mGuard:Ljava/lang/Object;

    monitor-enter v6

    .line 131
    :try_start_1
    iget v5, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticatorsVersion:I

    if-ne v1, v5, :cond_4

    .line 134
    iput-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticators:Ljava/util/List;

    .line 136
    :cond_4
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    :catchall_1
    move-exception v5

    monitor-exit v6

    throw v5
.end method

.method private removeMAPR5Applications(Ljava/util/List;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;"
        }
    .end annotation

    .prologue
    .local p1, "allSubAuths":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 303
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 305
    .local v1, "nonMapR5SubAuths":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .line 307
    .local v3, "subAuthenticator":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    iget-object v2, v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    .line 308
    .local v2, "packageName":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mMapInformationQueryer:Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    invoke-virtual {v4, v2}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v4

    .line 310
    if-nez v4, :cond_0

    .line 312
    sget-object v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v2, v4, v5

    .line 313
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 317
    :cond_0
    sget-object v4, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v2, v4, v5

    goto :goto_0

    .line 321
    .end local v2    # "packageName":Ljava/lang/String;
    .end local v3    # "subAuthenticator":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    :cond_1
    return-object v1
.end method


# virtual methods
.method public checkSignature(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)V
    .locals 5
    .param p1, "description"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;
        }
    .end annotation

    .prologue
    .line 232
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mTrustedPackageManager:Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;

    iget-object v2, p1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/TrustedPackageManager;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 234
    const-string/jumbo v1, "Package %s has a different signature from the authenticator."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 236
    .local v0, "message":Ljava/lang/String;
    new-instance v1, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/accounts/InvalidSubAuthenticatorDefinitionException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 238
    .end local v0    # "message":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public getSubAuthenticatorForTokenType(Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .locals 6
    .param p1, "desiredTokenType"    # Ljava/lang/String;

    .prologue
    .line 82
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->getSubAuthenticatorList()Ljava/util/List;

    move-result-object v3

    .line 84
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .line 86
    .local v0, "description":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    iget-object v3, v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->tokenTypes:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 88
    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 95
    .end local v0    # "description":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    .end local v2    # "i$":Ljava/util/Iterator;
    :goto_0
    return-object v0

    .line 94
    :cond_2
    sget-object v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "No SubAuthenticatorDescription found for the desired token type: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSubAuthenticators()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->getSubAuthenticatorList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public onRescanRequired()V
    .locals 2

    .prologue
    .line 100
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mGuard:Ljava/lang/Object;

    monitor-enter v1

    .line 102
    :try_start_0
    iget v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticatorsVersion:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticatorsVersion:I

    .line 103
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorRegistry;->mSubAuthenticators:Ljava/util/List;

    .line 104
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
