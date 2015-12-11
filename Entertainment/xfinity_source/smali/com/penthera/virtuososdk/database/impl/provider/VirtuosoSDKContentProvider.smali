.class public abstract Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;
.super Landroid/content/ContentProvider;
.source "VirtuosoSDKContentProvider.java"

# interfaces
.implements Landroid/os/Handler$Callback;


# static fields
.field private static final CATALOG_URI_LIST:Landroid/net/Uri;

.field private static final LOG_TAG:Ljava/lang/String;

.field private static iCatalogProjectionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final iCatalogUriMatcher:Landroid/content/UriMatcher;

.field private static iFileProjectionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final iFileUriMatcher:Landroid/content/UriMatcher;

.field private static iFragmentProjectionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final iFragmentUriMatcher:Landroid/content/UriMatcher;

.field private static iNetworkProjectionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static iNetworkUriMatcher:Landroid/content/UriMatcher;

.field private static iProviderProjectionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final iProviderUriMatcher:Landroid/content/UriMatcher;

.field private static iRegistryProjectionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final iRegistryUriMatcher:Landroid/content/UriMatcher;


# instance fields
.field private catalog_enabled:Z

.field private mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 85
    const-class v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->LOG_TAG:Ljava/lang/String;

    .line 145
    new-instance v0, Landroid/content/UriMatcher;

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    .line 146
    new-instance v0, Landroid/content/UriMatcher;

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    .line 147
    new-instance v0, Landroid/content/UriMatcher;

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    .line 148
    new-instance v0, Landroid/content/UriMatcher;

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    .line 149
    new-instance v0, Landroid/content/UriMatcher;

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    .line 151
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderProjectionMap:Ljava/util/HashMap;

    .line 152
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderProjectionMap:Ljava/util/HashMap;

    const-string v1, "_id"

    const-string v2, "_id"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderProjectionMap:Ljava/util/HashMap;

    const-string v1, "provider"

    const-string v2, "provider"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    .line 156
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "_id"

    const-string v2, "_id"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 157
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "uuid"

    const-string v2, "uuid"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 158
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "parentUuid"

    const-string v2, "parentUuid"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 159
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "assetUrl"

    const-string v2, "assetUrl"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 160
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "description"

    const-string v2, "description"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "expectedSize"

    const-string v2, "expectedSize"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 162
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "currentSize"

    const-string v2, "currentSize"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "filePath"

    const-string v2, "filePath"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 164
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "errorType"

    const-string v2, "errorType"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "assetId"

    const-string v2, "assetId"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 166
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "mimeType"

    const-string v2, "mimeType"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 167
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "fileHash"

    const-string v2, "fileHash"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 168
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "errorCount"

    const-string v2, "errorCount"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "creationTime"

    const-string v2, "creationTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "modifyTime"

    const-string v2, "modifyTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "completeTime"

    const-string v2, "completeTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 172
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "pending"

    const-string v2, "pending"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 173
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "addedToQueue"

    const-string v2, "addedToQueue"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "contentType"

    const-string v2, "contentType"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "clientAuthority"

    const-string v2, "clientAuthority"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 176
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "hashState"

    const-string v2, "hashState"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "hlsFragmentCount"

    const-string v2, "hlsFragmentCount"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "hlsFragmentCompletedCount"

    const-string v2, "hlsFragmentCompletedCount"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    const-string v1, "contentState"

    const-string v2, "contentState"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryProjectionMap:Ljava/util/HashMap;

    .line 182
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryProjectionMap:Ljava/util/HashMap;

    const-string v1, "_id"

    const-string v2, "_id"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 183
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryProjectionMap:Ljava/util/HashMap;

    const-string v1, "name"

    const-string v2, "name"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryProjectionMap:Ljava/util/HashMap;

    const-string v1, "value"

    const-string v2, "value"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 187
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    .line 188
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "_id"

    const-string v2, "_id"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "parentUuid"

    const-string v2, "parentUuid"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 190
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "assetUrl"

    const-string v2, "assetUrl"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 191
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "expectedSize"

    const-string v2, "expectedSize"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 192
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "currentSize"

    const-string v2, "currentSize"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 193
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "filePath"

    const-string v2, "filePath"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 194
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "errorType"

    const-string v2, "errorType"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 195
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "creationTime"

    const-string v2, "creationTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 196
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "modifyTime"

    const-string v2, "modifyTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "completeTime"

    const-string v2, "completeTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    const-string v1, "pending"

    const-string v2, "pending"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    .line 201
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "_id"

    const-string v2, "_id"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 202
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "accessWindow"

    const-string v2, "accessWindow"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 203
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "category"

    const-string v2, "category"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 204
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "catalogExpiry"

    const-string v2, "catalogExpiry"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 205
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "completeTime"

    const-string v2, "completeTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 206
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "vnd.android.cursor.item/vnd.virtuososdk.Catalog"

    const-string v2, "vnd.android.cursor.item/vnd.virtuososdk.Catalog"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 207
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "contentRating"

    const-string v2, "contentRating"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 208
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "vnd.android.cursor.dir/vnd.virtuososdk.Catalog"

    const-string v2, "vnd.android.cursor.dir/vnd.virtuososdk.Catalog"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "contentUrl"

    const-string v2, "contentUrl"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 210
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "creationTime"

    const-string v2, "creationTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 211
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "desc"

    const-string v2, "desc"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 212
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "downloadEnabled"

    const-string v2, "downloadEnabled"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 213
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "downloadExpiry"

    const-string v2, "downloadExpiry"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 214
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "duration"

    const-string v2, "duration"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 215
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "expiryDate"

    const-string v2, "expiryDate"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 216
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "featured"

    const-string v2, "featured"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "genre"

    const-string v2, "genre"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "image"

    const-string v2, "image"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "thumbnail"

    const-string v2, "thumbnail"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 220
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "modifyTime"

    const-string v2, "modifyTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 221
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "parent"

    const-string v2, "parent"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "streamUrl"

    const-string v2, "streamUrl"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "viewedTime"

    const-string v2, "viewedTime"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "popular"

    const-string v2, "popular"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 225
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "title"

    const-string v2, "title"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "type"

    const-string v2, "type"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 227
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "filePath"

    const-string v2, "filePath"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 228
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "errorType"

    const-string v2, "errorType"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 229
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "fileUuid"

    const-string v2, "fileUuid"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 230
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "userRating"

    const-string v2, "userRating"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 231
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    const-string v1, "network"

    const-string v2, "network"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 233
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkProjectionMap:Ljava/util/HashMap;

    .line 234
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkProjectionMap:Ljava/util/HashMap;

    const-string v1, "_id"

    const-string v2, "_id"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 235
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkProjectionMap:Ljava/util/HashMap;

    const-string v1, "network_name"

    const-string v2, "network_name"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 236
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkProjectionMap:Ljava/util/HashMap;

    const-string v1, "network_image_url"

    const-string v2, "network_image_url"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 237
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkProjectionMap:Ljava/util/HashMap;

    const-string v1, "network_image_thumbnail_url"

    const-string v2, "network_image_thumbnail_url"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 765
    const-string v0, "content://com.penthera.baratheon.catalog/list/"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->CATALOG_URI_LIST:Landroid/net/Uri;

    .line 84
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 243
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 241
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->catalog_enabled:Z

    .line 244
    return-void
.end method

.method private deleteCatalog(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 7
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aWhere"    # Ljava/lang/String;
    .param p3, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 644
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 645
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v0, 0x0

    .line 647
    .local v0, "count":I
    :try_start_0
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 658
    :pswitch_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Unknown URI "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 661
    :catchall_0
    move-exception v3

    .line 662
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 663
    throw v3

    .line 649
    :pswitch_1
    :try_start_1
    const-string v3, "catalog"

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    .line 662
    :goto_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 664
    return v0

    .line 653
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 654
    .local v2, "fileDbId":Ljava/lang/String;
    const-string v4, "catalog"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "_id="

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v6, " AND ("

    invoke-direct {v3, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v6, 0x29

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_1
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v4, v3, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 655
    goto :goto_0

    .line 654
    :cond_0
    const-string v3, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 647
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private deleteFile(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 15
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aWhere"    # Ljava/lang/String;
    .param p3, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 668
    iget-object v11, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v11}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v7

    .line 671
    .local v7, "db":Landroid/database/sqlite/SQLiteDatabase;
    move-object/from16 v0, p3

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAssetId([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 674
    .local v4, "assetId":Ljava/lang/String;
    :try_start_0
    sget-object v11, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v11

    packed-switch v11, :pswitch_data_0

    .line 704
    :pswitch_0
    new-instance v11, Ljava/lang/IllegalArgumentException;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "Unknown URI "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 707
    :catchall_0
    move-exception v11

    .line 708
    iget-object v12, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v12}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 709
    throw v11

    .line 676
    :pswitch_1
    :try_start_1
    const-string v11, "file"

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-virtual {v7, v11, v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v6

    .line 708
    .local v6, "count":I
    :goto_0
    iget-object v11, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v11}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 711
    if-lez v6, :cond_1

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_0

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-direct {p0, v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->isDeleteAll(Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_1

    .line 712
    :cond_0
    invoke-direct {p0, v4}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->deleteJoinCatalog(Ljava/lang/String;)V

    .line 715
    :cond_1
    return v6

    .line 680
    .end local v6    # "count":I
    :pswitch_2
    :try_start_2
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v11

    const/4 v12, 0x2

    invoke-interface {v11, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 681
    .local v5, "contentUuid":Ljava/lang/String;
    const/4 v10, 0x0

    check-cast v10, [Ljava/lang/String;

    .line 682
    .local v10, "newArgs":[Ljava/lang/String;
    if-eqz p3, :cond_3

    .line 683
    move-object/from16 v0, p3

    array-length v11, v0

    add-int/lit8 v11, v11, 0x1

    new-array v10, v11, [Ljava/lang/String;

    .line 684
    const/4 v2, 0x0

    .line 685
    .local v2, "argIdx":I
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "argIdx":I
    .local v3, "argIdx":I
    aput-object v5, v10, v2

    .line 686
    const/4 v9, 0x0

    .local v9, "idx":I
    :goto_1
    move-object/from16 v0, p3

    array-length v11, v0

    if-lt v9, v11, :cond_2

    .line 692
    .end local v3    # "argIdx":I
    .end local v9    # "idx":I
    :goto_2
    const-string v12, "file"

    new-instance v13, Ljava/lang/StringBuilder;

    const-string v11, "uuid=?"

    invoke-direct {v13, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_4

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v14, " AND ("

    invoke-direct {v11, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const/16 v14, 0x29

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    :goto_3
    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v7, v12, v11, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v6

    .line 695
    .restart local v6    # "count":I
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p1

    .line 696
    goto :goto_0

    .line 687
    .end local v6    # "count":I
    .restart local v3    # "argIdx":I
    .restart local v9    # "idx":I
    :cond_2
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "argIdx":I
    .restart local v2    # "argIdx":I
    aget-object v11, p3, v9

    aput-object v11, v10, v3

    .line 686
    add-int/lit8 v9, v9, 0x1

    move v3, v2

    .end local v2    # "argIdx":I
    .restart local v3    # "argIdx":I
    goto :goto_1

    .line 690
    .end local v3    # "argIdx":I
    .end local v9    # "idx":I
    :cond_3
    const/4 v11, 0x1

    new-array v10, v11, [Ljava/lang/String;

    .end local v10    # "newArgs":[Ljava/lang/String;
    const/4 v11, 0x0

    aput-object v5, v10, v11

    .restart local v10    # "newArgs":[Ljava/lang/String;
    goto :goto_2

    .line 692
    :cond_4
    const-string v11, ""

    goto :goto_3

    .line 699
    .end local v5    # "contentUuid":Ljava/lang/String;
    .end local v10    # "newArgs":[Ljava/lang/String;
    :pswitch_3
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v11

    const/4 v12, 0x1

    invoke-interface {v11, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 700
    .local v8, "fileDbId":Ljava/lang/String;
    const-string v12, "file"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v13, "_id="

    invoke-direct {v11, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_5

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v14, " AND ("

    invoke-direct {v11, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const/16 v14, 0x29

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    :goto_4
    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p3

    invoke-virtual {v7, v12, v11, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v6

    .line 701
    .restart local v6    # "count":I
    goto/16 :goto_0

    .line 700
    .end local v6    # "count":I
    :cond_5
    const-string v11, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_4

    .line 674
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method private deleteFragment(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 12
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aWhere"    # Ljava/lang/String;
    .param p3, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 601
    iget-object v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v4

    .line 602
    .local v4, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v3, 0x0

    .line 604
    .local v3, "count":I
    :try_start_0
    sget-object v8, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v8, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v8

    packed-switch v8, :pswitch_data_0

    .line 634
    :pswitch_0
    new-instance v8, Ljava/lang/IllegalArgumentException;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Unknown URI "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 637
    :catchall_0
    move-exception v8

    .line 638
    iget-object v9, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v9}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 639
    throw v8

    .line 606
    :pswitch_1
    :try_start_1
    const-string v8, "fragment"

    invoke-virtual {v4, v8, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    .line 638
    :goto_0
    iget-object v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 640
    return v3

    .line 610
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v9, 0x2

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 611
    .local v2, "contentUuid":Ljava/lang/String;
    const/4 v7, 0x0

    check-cast v7, [Ljava/lang/String;

    .line 612
    .local v7, "newArgs":[Ljava/lang/String;
    if-eqz p3, :cond_1

    .line 613
    array-length v8, p3

    add-int/lit8 v8, v8, 0x1

    new-array v7, v8, [Ljava/lang/String;

    .line 614
    const/4 v0, 0x0

    .line 615
    .local v0, "argIdx":I
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "argIdx":I
    .local v1, "argIdx":I
    aput-object v2, v7, v0

    .line 616
    const/4 v6, 0x0

    .local v6, "idx":I
    :goto_1
    array-length v8, p3

    if-lt v6, v8, :cond_0

    .line 622
    .end local v1    # "argIdx":I
    .end local v6    # "idx":I
    :goto_2
    const-string v9, "fragment"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v8, "parentUuid=?"

    invoke-direct {v10, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_2

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v11, " AND ("

    invoke-direct {v8, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const/16 v11, 0x29

    invoke-virtual {v8, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_3
    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v9, v8, v7}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 625
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p1

    .line 626
    goto :goto_0

    .line 617
    .restart local v1    # "argIdx":I
    .restart local v6    # "idx":I
    :cond_0
    add-int/lit8 v0, v1, 0x1

    .end local v1    # "argIdx":I
    .restart local v0    # "argIdx":I
    aget-object v8, p3, v6

    aput-object v8, v7, v1

    .line 616
    add-int/lit8 v6, v6, 0x1

    move v1, v0

    .end local v0    # "argIdx":I
    .restart local v1    # "argIdx":I
    goto :goto_1

    .line 620
    .end local v1    # "argIdx":I
    .end local v6    # "idx":I
    :cond_1
    const/4 v8, 0x1

    new-array v7, v8, [Ljava/lang/String;

    .end local v7    # "newArgs":[Ljava/lang/String;
    const/4 v8, 0x0

    aput-object v2, v7, v8

    .restart local v7    # "newArgs":[Ljava/lang/String;
    goto :goto_2

    .line 622
    :cond_2
    const-string v8, ""

    goto :goto_3

    .line 629
    .end local v2    # "contentUuid":Ljava/lang/String;
    .end local v7    # "newArgs":[Ljava/lang/String;
    :pswitch_3
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v9, 0x1

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 630
    .local v5, "fileDbId":Ljava/lang/String;
    const-string v9, "fragment"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v10, "_id="

    invoke-direct {v8, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_3

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v11, " AND ("

    invoke-direct {v8, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const/16 v11, 0x29

    invoke-virtual {v8, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_4
    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v9, v8, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 631
    goto/16 :goto_0

    .line 630
    :cond_3
    const-string v8, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_4

    .line 604
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method private deleteJoinCatalog(Ljava/lang/String;)V
    .locals 7
    .param p1, "assetId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 773
    iget-boolean v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->catalog_enabled:Z

    if-nez v3, :cond_0

    .line 801
    :goto_0
    return-void

    .line 775
    :cond_0
    :try_start_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 778
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 779
    .local v0, "cv":Landroid/content/ContentValues;
    const-string v3, "filePath"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 780
    const-string v3, "errorType"

    const/4 v4, -0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 781
    const-string v3, "fileUuid"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 782
    const-string v3, "viewedTime"

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 783
    const-string v3, "completeTime"

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 786
    const/4 v2, -0x1

    .line 787
    .local v2, "mod":I
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 788
    const-string v3, "catalog"

    const-string v4, "_id=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    invoke-virtual {v1, v3, v0, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 793
    :goto_1
    if-gtz v2, :cond_2

    .line 794
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "delete error: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 799
    :goto_2
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    goto :goto_0

    .line 790
    :cond_1
    :try_start_1
    const-string v3, "catalog"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v1, v3, v0, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    goto :goto_1

    .line 796
    :cond_2
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->CATALOG_URI_LIST:Landroid/net/Uri;

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2

    .line 798
    .end local v0    # "cv":Landroid/content/ContentValues;
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "mod":I
    :catchall_0
    move-exception v3

    .line 799
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 800
    throw v3
.end method

.method private deleteProvider(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 7
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aWhere"    # Ljava/lang/String;
    .param p3, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 577
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 578
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v0, 0x0

    .line 580
    .local v0, "count":I
    :try_start_0
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 591
    :pswitch_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Unknown URI "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 594
    :catchall_0
    move-exception v3

    .line 595
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 596
    throw v3

    .line 582
    :pswitch_1
    :try_start_1
    const-string v3, "providers"

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    .line 595
    :goto_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 597
    return v0

    .line 586
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 587
    .local v2, "fileDbId":Ljava/lang/String;
    const-string v4, "providers"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "_id="

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v6, " AND ("

    invoke-direct {v3, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v6, 0x29

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_1
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v4, v3, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 588
    goto :goto_0

    .line 587
    :cond_0
    const-string v3, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 580
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private deleteRegistry(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 8
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aWhere"    # Ljava/lang/String;
    .param p3, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 804
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 808
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v4, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 825
    :pswitch_0
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Unknown URI "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 828
    :catchall_0
    move-exception v4

    .line 829
    iget-object v5, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v5}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 830
    throw v4

    .line 810
    :pswitch_1
    :try_start_1
    const-string v4, "registry"

    invoke-virtual {v1, v4, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    .line 829
    .local v0, "count":I
    :goto_0
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 832
    return v0

    .line 814
    .end local v0    # "count":I
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 815
    .local v3, "registryName":Ljava/lang/String;
    const-string v5, "registry"

    .line 816
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "name=\'"

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "\'"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v7, " AND ("

    invoke-direct {v4, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v7, 0x29

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    :goto_1
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 815
    invoke-virtual {v1, v5, v4, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 817
    .restart local v0    # "count":I
    goto :goto_0

    .line 816
    .end local v0    # "count":I
    :cond_0
    const-string v4, ""

    goto :goto_1

    .line 820
    .end local v3    # "registryName":Ljava/lang/String;
    :pswitch_3
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x1

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 821
    .local v2, "registryDbId":Ljava/lang/String;
    const-string v5, "registry"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "_id="

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v7, " AND ("

    invoke-direct {v4, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v7, 0x29

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    :goto_2
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v5, v4, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 822
    .restart local v0    # "count":I
    goto/16 :goto_0

    .line 821
    .end local v0    # "count":I
    :cond_1
    const-string v4, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 808
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private fragmentBulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    .locals 8
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "values"    # [Landroid/content/ContentValues;

    .prologue
    .line 531
    const/4 v4, 0x0

    .line 532
    .local v4, "numInserted":I
    iget-object v5, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v5}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 533
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 535
    const/4 v1, 0x0

    .local v1, "idx":I
    :goto_0
    :try_start_0
    array-length v5, p2

    if-lt v1, v5, :cond_0

    .line 542
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 543
    array-length v4, p2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 545
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 546
    iget-object v5, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v5}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 548
    return v4

    .line 537
    :cond_0
    :try_start_1
    const-string v5, "fragment"

    const/4 v6, 0x0

    aget-object v7, p2, v1

    invoke-virtual {v0, v5, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    .line 538
    .local v2, "newID":J
    const-wide/16 v6, 0x0

    cmp-long v5, v2, v6

    if-gtz v5, :cond_1

    .line 539
    new-instance v5, Landroid/database/SQLException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Failed to insert row into "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/database/SQLException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 544
    .end local v2    # "newID":J
    :catchall_0
    move-exception v5

    .line 545
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 546
    iget-object v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 547
    throw v5

    .line 535
    .restart local v2    # "newID":J
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private getAssetId([Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p1, "aArgs"    # [Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 734
    const/4 v8, 0x0

    .line 735
    .local v8, "assetId":Ljava/lang/String;
    const/4 v9, 0x0

    .line 737
    .local v9, "c":Landroid/database/Cursor;
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 739
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz p1, :cond_1

    array-length v1, p1

    if-ne v1, v2, :cond_1

    .line 740
    const/4 v1, 0x0

    aget-object v10, p1, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 744
    .local v10, "uuid":Ljava/lang/String;
    :try_start_1
    const-string v1, "file"

    const/4 v2, 0x0

    const-string v3, "uuid=?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v10, v4, v5

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 745
    if-eqz v9, :cond_0

    .line 746
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 747
    const-string v1, "assetId"

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v9, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v8

    .line 751
    :cond_0
    if-eqz v9, :cond_1

    .line 752
    :try_start_2
    invoke-interface {v9}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 753
    const/4 v9, 0x0

    .line 758
    .end local v10    # "uuid":Ljava/lang/String;
    :cond_1
    iget-object v1, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 761
    return-object v8

    .line 750
    .restart local v10    # "uuid":Ljava/lang/String;
    :catchall_0
    move-exception v1

    .line 751
    if-eqz v9, :cond_2

    .line 752
    :try_start_3
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 753
    const/4 v9, 0x0

    .line 755
    :cond_2
    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 757
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v10    # "uuid":Ljava/lang/String;
    :catchall_1
    move-exception v1

    .line 758
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 759
    throw v1
.end method

.method private insertCatalog(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 9
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValueSet"    # Landroid/content/ContentValues;

    .prologue
    .line 406
    if-eqz p2, :cond_2

    .line 407
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3, p2}, Landroid/content/ContentValues;-><init>(Landroid/content/ContentValues;)V

    .line 413
    .local v3, "values":Landroid/content/ContentValues;
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 414
    .local v2, "now":Ljava/lang/Long;
    const-string v6, "creationTime"

    invoke-virtual {v3, v6}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 415
    const-string v6, "creationTime"

    invoke-virtual {v3, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 417
    :cond_0
    const-string v6, "modifyTime"

    invoke-virtual {v3, v6}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 418
    const-string v6, "modifyTime"

    invoke-virtual {v3, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 421
    :cond_1
    iget-object v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 423
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v4, -0x1

    .line 425
    .local v4, "rowId":J
    :try_start_0
    const-string v6, "catalog"

    const-string v7, "desc"

    invoke-virtual {v1, v6, v7, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v4

    .line 427
    iget-object v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 430
    const-wide/16 v6, -0x1

    cmp-long v6, v4, v6

    if-lez v6, :cond_3

    .line 431
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/penthera/virtuososdk/database/impl/provider/Catalog$CatalogColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-static {v6, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    .line 432
    .local v0, "contentDbUri":Landroid/net/Uri;
    return-object v0

    .line 410
    .end local v0    # "contentDbUri":Landroid/net/Uri;
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "now":Ljava/lang/Long;
    .end local v3    # "values":Landroid/content/ContentValues;
    .end local v4    # "rowId":J
    :cond_2
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .restart local v3    # "values":Landroid/content/ContentValues;
    goto :goto_0

    .line 426
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v2    # "now":Ljava/lang/Long;
    .restart local v4    # "rowId":J
    :catchall_0
    move-exception v6

    .line 427
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 428
    throw v6

    .line 435
    :cond_3
    new-instance v6, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Failed to insert row into "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6
.end method

.method private insertFile(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 10
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValueSet"    # Landroid/content/ContentValues;

    .prologue
    .line 441
    if-eqz p2, :cond_0

    .line 442
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6, p2}, Landroid/content/ContentValues;-><init>(Landroid/content/ContentValues;)V

    .line 448
    .local v6, "values":Landroid/content/ContentValues;
    :goto_0
    const-string v7, "uuid"

    invoke-virtual {v6, v7}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 449
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "New Files must have a UUID"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 445
    .end local v6    # "values":Landroid/content/ContentValues;
    :cond_0
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6}, Landroid/content/ContentValues;-><init>()V

    .restart local v6    # "values":Landroid/content/ContentValues;
    goto :goto_0

    .line 452
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    .line 453
    .local v3, "now":Ljava/lang/Long;
    const-string v7, "creationTime"

    invoke-virtual {v6, v7}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 454
    const-string v7, "creationTime"

    invoke-virtual {v6, v7, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 456
    :cond_2
    const-string v7, "modifyTime"

    invoke-virtual {v6, v7}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 457
    const-string v7, "modifyTime"

    invoke-virtual {v6, v7, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 460
    :cond_3
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 462
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v4, -0x1

    .line 464
    .local v4, "rowId":J
    :try_start_0
    const-string v7, "file"

    const-string v8, "description"

    invoke-virtual {v1, v7, v8, v6}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v4

    .line 466
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 469
    const-wide/16 v8, -0x1

    cmp-long v7, v4, v8

    if-lez v7, :cond_4

    .line 471
    :try_start_1
    invoke-direct {p0, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->updateJoinCatalog(Landroid/content/ContentValues;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 476
    :goto_1
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-static {v7, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    .line 477
    .local v0, "contentDbUri":Landroid/net/Uri;
    return-object v0

    .line 465
    .end local v0    # "contentDbUri":Landroid/net/Uri;
    :catchall_0
    move-exception v7

    .line 466
    iget-object v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 467
    throw v7

    .line 472
    :catch_0
    move-exception v2

    .line 473
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 480
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_4
    new-instance v7, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Failed to insert row into "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7
.end method

.method private insertFragment(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 9
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValueSet"    # Landroid/content/ContentValues;

    .prologue
    .line 369
    if-eqz p2, :cond_0

    .line 370
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3, p2}, Landroid/content/ContentValues;-><init>(Landroid/content/ContentValues;)V

    .line 375
    .local v3, "values":Landroid/content/ContentValues;
    :goto_0
    const-string v6, "parentUuid"

    invoke-virtual {v3, v6}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 376
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "New Fragments must have a PARENT_UUID"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 373
    .end local v3    # "values":Landroid/content/ContentValues;
    :cond_0
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .restart local v3    # "values":Landroid/content/ContentValues;
    goto :goto_0

    .line 379
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 380
    .local v2, "now":Ljava/lang/Long;
    const-string v6, "creationTime"

    invoke-virtual {v3, v6}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 381
    const-string v6, "creationTime"

    invoke-virtual {v3, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 383
    :cond_2
    const-string v6, "modifyTime"

    invoke-virtual {v3, v6}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 384
    const-string v6, "modifyTime"

    invoke-virtual {v3, v6, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 387
    :cond_3
    iget-object v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 389
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v4, -0x1

    .line 391
    .local v4, "rowId":J
    :try_start_0
    const-string v6, "fragment"

    const-string v7, "filePath"

    invoke-virtual {v1, v6, v7, v3}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v4

    .line 393
    iget-object v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 396
    const-wide/16 v6, -0x1

    cmp-long v6, v4, v6

    if-lez v6, :cond_4

    .line 397
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-static {v6, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    .line 398
    .local v0, "contentDbUri":Landroid/net/Uri;
    return-object v0

    .line 392
    .end local v0    # "contentDbUri":Landroid/net/Uri;
    :catchall_0
    move-exception v6

    .line 393
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 394
    throw v6

    .line 401
    :cond_4
    new-instance v6, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Failed to insert row into "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6
.end method

.method private insertProvider(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 7
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValueSet"    # Landroid/content/ContentValues;

    .prologue
    .line 350
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 352
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v2, -0x1

    .line 354
    .local v2, "rowId":J
    :try_start_0
    const-string v4, "providers"

    const/4 v5, 0x0

    invoke-virtual {v1, v4, v5, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    .line 356
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 359
    const-wide/16 v4, -0x1

    cmp-long v4, v2, v4

    if-lez v4, :cond_0

    .line 360
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/penthera/virtuososdk/database/impl/provider/Provider$ProviderColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-static {v4, v2, v3}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    .line 361
    .local v0, "contentDbUri":Landroid/net/Uri;
    return-object v0

    .line 355
    .end local v0    # "contentDbUri":Landroid/net/Uri;
    :catchall_0
    move-exception v4

    .line 356
    iget-object v5, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v5}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 357
    throw v4

    .line 364
    :cond_0
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Failed to insert row into "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method private insertRegistry(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 10
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValueSet"    # Landroid/content/ContentValues;

    .prologue
    .line 485
    if-nez p2, :cond_0

    .line 486
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "Insertion must have values"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 489
    :cond_0
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6, p2}, Landroid/content/ContentValues;-><init>(Landroid/content/ContentValues;)V

    .line 491
    .local v6, "values":Landroid/content/ContentValues;
    const-string v7, "name"

    invoke-virtual {v6, v7}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    const-string v7, "value"

    invoke-virtual {v6, v7}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 492
    :cond_1
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "New registry entry must have a name and a value"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 495
    :cond_2
    const-string v7, "name"

    invoke-virtual {v6, v7}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 497
    .local v1, "name":Ljava/lang/String;
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 499
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const-wide/16 v4, -0x1

    .line 501
    .local v4, "rowId":J
    :try_start_0
    const-string v7, "registry"

    const-string v8, "value"

    invoke-virtual {v0, v7, v8, v6}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v4

    .line 503
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 506
    const-wide/16 v8, -0x1

    cmp-long v7, v4, v8

    if-lez v7, :cond_3

    .line 507
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/penthera/virtuososdk/database/impl/provider/Registry$RegistryColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "/name/"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 508
    .local v3, "registryNameUri":Landroid/net/Uri;
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/database/impl/provider/Registry$RegistryColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-static {v7, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v2

    .line 509
    .local v2, "registryDbUri":Landroid/net/Uri;
    return-object v3

    .line 502
    .end local v2    # "registryDbUri":Landroid/net/Uri;
    .end local v3    # "registryNameUri":Landroid/net/Uri;
    :catchall_0
    move-exception v7

    .line 503
    iget-object v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 504
    throw v7

    .line 512
    :cond_3
    new-instance v7, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Failed to insert row into "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7
.end method

.method private isDeleteAll(Ljava/lang/String;[Ljava/lang/String;)Z
    .locals 3
    .param p1, "aWhere"    # Ljava/lang/String;
    .param p2, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 720
    const-string v1, "clientAuthority =?"

    .line 724
    .local v1, "where":Ljava/lang/String;
    :try_start_0
    const-string v2, "clientAuthority =?"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-eqz v2, :cond_0

    .line 725
    const/4 v2, 0x1

    .line 730
    :goto_0
    return v2

    .line 727
    :catch_0
    move-exception v0

    .line 728
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 730
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private queryCatalog(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aProjection"    # [Ljava/lang/String;
    .param p3, "aSelection"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;
    .param p5, "aSortOrder"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 945
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 946
    .local v0, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    const-string v2, "catalog"

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 947
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogProjectionMap:Ljava/util/HashMap;

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 949
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 958
    :pswitch_0
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Unknown URI "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 954
    :pswitch_1
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "_id="

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x1

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 963
    :pswitch_2
    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 964
    const-string v7, "_id ASC "

    .line 971
    .local v7, "orderBy":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, v5

    .line 972
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 973
    .local v8, "c":Landroid/database/Cursor;
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 975
    return-object v8

    .line 967
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v7    # "orderBy":Ljava/lang/String;
    .end local v8    # "c":Landroid/database/Cursor;
    :cond_0
    move-object v7, p5

    .restart local v7    # "orderBy":Ljava/lang/String;
    goto :goto_0

    .line 949
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private queryFile(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 15
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aProjection"    # [Ljava/lang/String;
    .param p3, "aSelection"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;
    .param p5, "aSortOrder"    # Ljava/lang/String;

    .prologue
    .line 979
    new-instance v1, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v1}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 980
    .local v1, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    const-string v3, "file"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 981
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileProjectionMap:Ljava/util/HashMap;

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 983
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 1010
    :pswitch_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Unknown URI "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 989
    :pswitch_1
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x2

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 990
    .local v12, "id":Ljava/lang/String;
    const/4 v14, 0x0

    check-cast v14, [Ljava/lang/String;

    .line 991
    .local v14, "newArgs":[Ljava/lang/String;
    if-eqz p4, :cond_1

    .line 992
    move-object/from16 v0, p4

    array-length v3, v0

    add-int/lit8 v3, v3, 0x1

    new-array v14, v3, [Ljava/lang/String;

    .line 993
    const/4 v9, 0x0

    .line 994
    .local v9, "argIdx":I
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "argIdx":I
    .local v10, "argIdx":I
    aput-object v12, v14, v9

    .line 995
    const/4 v13, 0x0

    .local v13, "idx":I
    move v9, v10

    .end local v10    # "argIdx":I
    .restart local v9    # "argIdx":I
    :goto_0
    move-object/from16 v0, p4

    array-length v3, v0

    if-lt v13, v3, :cond_0

    .line 1001
    .end local v9    # "argIdx":I
    .end local v13    # "idx":I
    :goto_1
    move-object/from16 p4, v14

    .line 1002
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v3, "uuid=?"

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static/range {p3 .. p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, " AND ("

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v5, 0x29

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_2
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 1015
    .end local v12    # "id":Ljava/lang/String;
    .end local v14    # "newArgs":[Ljava/lang/String;
    :goto_3
    :pswitch_2
    invoke-static/range {p5 .. p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1016
    const-string v8, "_id ASC "

    .line 1023
    .local v8, "orderBy":Ljava/lang/String;
    :goto_4
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 1024
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 1025
    .local v11, "c":Landroid/database/Cursor;
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1027
    return-object v11

    .line 996
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v11    # "c":Landroid/database/Cursor;
    .restart local v9    # "argIdx":I
    .restart local v12    # "id":Ljava/lang/String;
    .restart local v13    # "idx":I
    .restart local v14    # "newArgs":[Ljava/lang/String;
    :cond_0
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "argIdx":I
    .restart local v10    # "argIdx":I
    aget-object v3, p4, v13

    aput-object v3, v14, v9

    .line 995
    add-int/lit8 v13, v13, 0x1

    move v9, v10

    .end local v10    # "argIdx":I
    .restart local v9    # "argIdx":I
    goto :goto_0

    .line 999
    .end local v9    # "argIdx":I
    .end local v13    # "idx":I
    :cond_1
    const/4 v3, 0x1

    new-array v14, v3, [Ljava/lang/String;

    .end local v14    # "newArgs":[Ljava/lang/String;
    const/4 v3, 0x0

    aput-object v12, v14, v3

    .restart local v14    # "newArgs":[Ljava/lang/String;
    goto :goto_1

    .line 1002
    :cond_2
    const-string v3, ""

    goto :goto_2

    .line 1006
    .end local v12    # "id":Ljava/lang/String;
    .end local v14    # "newArgs":[Ljava/lang/String;
    :pswitch_3
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v3, "_id="

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v5, 0x1

    invoke-interface {v3, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    goto :goto_3

    .line 1019
    :cond_3
    move-object/from16 v8, p5

    .restart local v8    # "orderBy":Ljava/lang/String;
    goto :goto_4

    .line 983
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method private queryFragment(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 15
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aProjection"    # [Ljava/lang/String;
    .param p3, "aSelection"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;
    .param p5, "aSortOrder"    # Ljava/lang/String;

    .prologue
    .line 894
    new-instance v1, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v1}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 895
    .local v1, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    const-string v3, "fragment"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 896
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentProjectionMap:Ljava/util/HashMap;

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 898
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 924
    :pswitch_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Unknown URI "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 903
    :pswitch_1
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x2

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 904
    .local v12, "id":Ljava/lang/String;
    const/4 v14, 0x0

    check-cast v14, [Ljava/lang/String;

    .line 905
    .local v14, "newArgs":[Ljava/lang/String;
    if-eqz p4, :cond_1

    .line 906
    move-object/from16 v0, p4

    array-length v3, v0

    add-int/lit8 v3, v3, 0x1

    new-array v14, v3, [Ljava/lang/String;

    .line 907
    const/4 v9, 0x0

    .line 908
    .local v9, "argIdx":I
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "argIdx":I
    .local v10, "argIdx":I
    aput-object v12, v14, v9

    .line 909
    const/4 v13, 0x0

    .local v13, "idx":I
    move v9, v10

    .end local v10    # "argIdx":I
    .restart local v9    # "argIdx":I
    :goto_0
    move-object/from16 v0, p4

    array-length v3, v0

    if-lt v13, v3, :cond_0

    .line 915
    .end local v9    # "argIdx":I
    .end local v13    # "idx":I
    :goto_1
    move-object/from16 p4, v14

    .line 916
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v3, "parentUuid=?"

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static/range {p3 .. p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, " AND ("

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v5, 0x29

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_2
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 929
    .end local v12    # "id":Ljava/lang/String;
    .end local v14    # "newArgs":[Ljava/lang/String;
    :goto_3
    :pswitch_2
    invoke-static/range {p5 .. p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 930
    const-string v8, "_id ASC "

    .line 937
    .local v8, "orderBy":Ljava/lang/String;
    :goto_4
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 938
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 939
    .local v11, "c":Landroid/database/Cursor;
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 941
    return-object v11

    .line 910
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "orderBy":Ljava/lang/String;
    .end local v11    # "c":Landroid/database/Cursor;
    .restart local v9    # "argIdx":I
    .restart local v12    # "id":Ljava/lang/String;
    .restart local v13    # "idx":I
    .restart local v14    # "newArgs":[Ljava/lang/String;
    :cond_0
    add-int/lit8 v10, v9, 0x1

    .end local v9    # "argIdx":I
    .restart local v10    # "argIdx":I
    aget-object v3, p4, v13

    aput-object v3, v14, v9

    .line 909
    add-int/lit8 v13, v13, 0x1

    move v9, v10

    .end local v10    # "argIdx":I
    .restart local v9    # "argIdx":I
    goto :goto_0

    .line 913
    .end local v9    # "argIdx":I
    .end local v13    # "idx":I
    :cond_1
    const/4 v3, 0x1

    new-array v14, v3, [Ljava/lang/String;

    .end local v14    # "newArgs":[Ljava/lang/String;
    const/4 v3, 0x0

    aput-object v12, v14, v3

    .restart local v14    # "newArgs":[Ljava/lang/String;
    goto :goto_1

    .line 916
    :cond_2
    const-string v3, ""

    goto :goto_2

    .line 920
    .end local v12    # "id":Ljava/lang/String;
    .end local v14    # "newArgs":[Ljava/lang/String;
    :pswitch_3
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v3, "_id="

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v5, 0x1

    invoke-interface {v3, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    goto :goto_3

    .line 933
    :cond_3
    move-object/from16 v8, p5

    .restart local v8    # "orderBy":Ljava/lang/String;
    goto :goto_4

    .line 898
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_1
    .end packed-switch
.end method

.method private queryProvider(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aProjection"    # [Ljava/lang/String;
    .param p3, "aSelection"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;
    .param p5, "aSortOrder"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 860
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 861
    .local v0, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    const-string v2, "providers"

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 862
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderProjectionMap:Ljava/util/HashMap;

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 864
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 873
    :pswitch_0
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Unknown URI "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 869
    :pswitch_1
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "_id="

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x1

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 878
    :pswitch_2
    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 879
    const-string v7, "_id ASC "

    .line 886
    .local v7, "orderBy":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, v5

    .line 887
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 888
    .local v8, "c":Landroid/database/Cursor;
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 890
    return-object v8

    .line 882
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v7    # "orderBy":Ljava/lang/String;
    .end local v8    # "c":Landroid/database/Cursor;
    :cond_0
    move-object v7, p5

    .restart local v7    # "orderBy":Ljava/lang/String;
    goto :goto_0

    .line 864
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private queryRegistry(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 9
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aProjection"    # [Ljava/lang/String;
    .param p3, "aSelection"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;
    .param p5, "aSortOrder"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 1031
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 1032
    .local v0, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    const-string v2, "registry"

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 1033
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryProjectionMap:Ljava/util/HashMap;

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setProjectionMap(Ljava/util/Map;)V

    .line 1035
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 1048
    :pswitch_0
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Unknown URI "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1040
    :pswitch_1
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "name=\'"

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x2

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    .line 1052
    :goto_0
    :pswitch_2
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, v5

    move-object v7, v5

    .line 1053
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 1054
    .local v8, "c":Landroid/database/Cursor;
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1056
    return-object v8

    .line 1044
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v8    # "c":Landroid/database/Cursor;
    :pswitch_3
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "_id="

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v4, 0x1

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 1035
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method

.method protected static setAuthority(Ljava/lang/String;)V
    .locals 5
    .param p0, "Authority"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x4

    const/4 v3, 0x1

    .line 120
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "content"

    invoke-virtual {v0, p0, v1, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 121
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "content/cid/*"

    const/4 v2, 0x2

    invoke-virtual {v0, p0, v1, v2}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 122
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "content/#"

    invoke-virtual {v0, p0, v1, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 124
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "registry"

    invoke-virtual {v0, p0, v1, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 125
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "registry/name/*"

    const/4 v2, 0x3

    invoke-virtual {v0, p0, v1, v2}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 126
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "registry/#"

    invoke-virtual {v0, p0, v1, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 128
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "fragment"

    invoke-virtual {v0, p0, v1, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 129
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "fragment/parent/*"

    const/4 v2, 0x5

    invoke-virtual {v0, p0, v1, v2}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 130
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "fragment/#"

    invoke-virtual {v0, p0, v1, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 132
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "provider"

    invoke-virtual {v0, p0, v1, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 133
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "provider/#"

    invoke-virtual {v0, p0, v1, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 135
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "catalog"

    invoke-virtual {v0, p0, v1, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 136
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "catalog/#"

    invoke-virtual {v0, p0, v1, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 138
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkUriMatcher:Landroid/content/UriMatcher;

    .line 139
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "network"

    invoke-virtual {v0, p0, v1, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 140
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkUriMatcher:Landroid/content/UriMatcher;

    const-string v1, "network/#"

    invoke-virtual {v0, p0, v1, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 142
    return-void
.end method

.method private updateCatalog(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 7
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValues"    # Landroid/content/ContentValues;
    .param p3, "aWhere"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 1159
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 1160
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v0, 0x0

    .line 1162
    .local v0, "count":I
    :try_start_0
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 1174
    :pswitch_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Unknown URI "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1178
    :catchall_0
    move-exception v3

    .line 1179
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1180
    throw v3

    .line 1164
    :pswitch_1
    :try_start_1
    const-string v3, "catalog"

    invoke-virtual {v1, v3, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    .line 1179
    :goto_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1182
    return v0

    .line 1168
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1169
    .local v2, "id":Ljava/lang/String;
    const-string v4, "catalog"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "_id="

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v6, " AND ("

    invoke-direct {v3, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v6, 0x29

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_1
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v4, p2, v3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 1171
    goto :goto_0

    .line 1169
    :cond_0
    const-string v3, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 1162
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private updateFile(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 15
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValues"    # Landroid/content/ContentValues;
    .param p3, "aWhere"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 1186
    iget-object v11, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v11}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v6

    .line 1190
    .local v6, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    sget-object v11, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v11

    packed-switch v11, :pswitch_data_0

    .line 1223
    :pswitch_0
    new-instance v11, Ljava/lang/IllegalArgumentException;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "Unknown URI "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1226
    :catchall_0
    move-exception v11

    .line 1227
    iget-object v12, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v12}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1228
    throw v11

    .line 1192
    :pswitch_1
    :try_start_1
    const-string v11, "file"

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v6, v11, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v5

    .line 1227
    .local v5, "count":I
    :goto_0
    iget-object v11, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v11}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1230
    if-lez v5, :cond_0

    .line 1232
    :try_start_2
    move-object/from16 v0, p2

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->updateJoinCatalog(Landroid/content/ContentValues;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 1238
    :cond_0
    :goto_1
    return v5

    .line 1197
    .end local v5    # "count":I
    :pswitch_2
    :try_start_3
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v11

    const/4 v12, 0x2

    invoke-interface {v11, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 1198
    .local v8, "id":Ljava/lang/String;
    const/4 v10, 0x0

    check-cast v10, [Ljava/lang/String;

    .line 1199
    .local v10, "newArgs":[Ljava/lang/String;
    if-eqz p4, :cond_2

    .line 1200
    move-object/from16 v0, p4

    array-length v11, v0

    add-int/lit8 v11, v11, 0x1

    new-array v10, v11, [Ljava/lang/String;

    .line 1201
    const/4 v3, 0x0

    .line 1202
    .local v3, "argIdx":I
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "argIdx":I
    .local v4, "argIdx":I
    aput-object v8, v10, v3

    .line 1203
    const/4 v9, 0x0

    .local v9, "idx":I
    :goto_2
    move-object/from16 v0, p4

    array-length v11, v0

    if-lt v9, v11, :cond_1

    .line 1209
    .end local v4    # "argIdx":I
    .end local v9    # "idx":I
    :goto_3
    const-string v12, "file"

    new-instance v13, Ljava/lang/StringBuilder;

    const-string v11, "uuid=?"

    invoke-direct {v13, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static/range {p3 .. p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_3

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v14, " AND ("

    invoke-direct {v11, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p3

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const/16 v14, 0x29

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    :goto_4
    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p2

    invoke-virtual {v6, v12, v0, v11, v10}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    .line 1211
    .restart local v5    # "count":I
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p1

    .line 1213
    goto :goto_0

    .line 1204
    .end local v5    # "count":I
    .restart local v4    # "argIdx":I
    .restart local v9    # "idx":I
    :cond_1
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "argIdx":I
    .restart local v3    # "argIdx":I
    aget-object v11, p4, v9

    aput-object v11, v10, v4

    .line 1203
    add-int/lit8 v9, v9, 0x1

    move v4, v3

    .end local v3    # "argIdx":I
    .restart local v4    # "argIdx":I
    goto :goto_2

    .line 1207
    .end local v4    # "argIdx":I
    .end local v9    # "idx":I
    :cond_2
    const/4 v11, 0x1

    new-array v10, v11, [Ljava/lang/String;

    .end local v10    # "newArgs":[Ljava/lang/String;
    const/4 v11, 0x0

    aput-object v8, v10, v11

    .restart local v10    # "newArgs":[Ljava/lang/String;
    goto :goto_3

    .line 1209
    :cond_3
    const-string v11, ""

    goto :goto_4

    .line 1217
    .end local v8    # "id":Ljava/lang/String;
    .end local v10    # "newArgs":[Ljava/lang/String;
    :pswitch_3
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v11

    const/4 v12, 0x1

    invoke-interface {v11, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 1218
    .restart local v8    # "id":Ljava/lang/String;
    const-string v12, "file"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v13, "_id="

    invoke-direct {v11, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-static/range {p3 .. p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_4

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v14, " AND ("

    invoke-direct {v11, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p3

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const/16 v14, 0x29

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    :goto_5
    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v6, v12, v0, v11, v1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v5

    .line 1220
    .restart local v5    # "count":I
    goto/16 :goto_0

    .line 1218
    .end local v5    # "count":I
    :cond_4
    const-string v11, ""
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_5

    .line 1233
    .end local v8    # "id":Ljava/lang/String;
    .restart local v5    # "count":I
    :catch_0
    move-exception v7

    .line 1234
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_1

    .line 1190
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method private updateFragment(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 11
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValues"    # Landroid/content/ContentValues;
    .param p3, "aWhere"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 1111
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 1112
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v2, 0x0

    .line 1114
    .local v2, "count":I
    :try_start_0
    sget-object v7, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v7, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v7

    packed-switch v7, :pswitch_data_0

    .line 1147
    :pswitch_0
    new-instance v7, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Unknown URI "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1151
    :catchall_0
    move-exception v7

    .line 1152
    iget-object v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1153
    throw v7

    .line 1116
    :pswitch_1
    :try_start_1
    const-string v7, "fragment"

    invoke-virtual {v3, v7, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    .line 1152
    :goto_0
    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1155
    return v2

    .line 1121
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v7

    const/4 v8, 0x2

    invoke-interface {v7, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 1122
    .local v4, "id":Ljava/lang/String;
    const/4 v6, 0x0

    check-cast v6, [Ljava/lang/String;

    .line 1123
    .local v6, "newArgs":[Ljava/lang/String;
    if-eqz p4, :cond_1

    .line 1124
    array-length v7, p4

    add-int/lit8 v7, v7, 0x1

    new-array v6, v7, [Ljava/lang/String;

    .line 1125
    const/4 v0, 0x0

    .line 1126
    .local v0, "argIdx":I
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "argIdx":I
    .local v1, "argIdx":I
    aput-object v4, v6, v0

    .line 1127
    const/4 v5, 0x0

    .local v5, "idx":I
    :goto_1
    array-length v7, p4

    if-lt v5, v7, :cond_0

    .line 1133
    .end local v1    # "argIdx":I
    .end local v5    # "idx":I
    :goto_2
    const-string v8, "fragment"

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v7, "parentUuid=?"

    invoke-direct {v9, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_2

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, " AND ("

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/16 v10, 0x29

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    :goto_3
    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v8, p2, v7, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 1135
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p1

    .line 1137
    goto :goto_0

    .line 1128
    .restart local v1    # "argIdx":I
    .restart local v5    # "idx":I
    :cond_0
    add-int/lit8 v0, v1, 0x1

    .end local v1    # "argIdx":I
    .restart local v0    # "argIdx":I
    aget-object v7, p4, v5

    aput-object v7, v6, v1

    .line 1127
    add-int/lit8 v5, v5, 0x1

    move v1, v0

    .end local v0    # "argIdx":I
    .restart local v1    # "argIdx":I
    goto :goto_1

    .line 1131
    .end local v1    # "argIdx":I
    .end local v5    # "idx":I
    :cond_1
    const/4 v7, 0x1

    new-array v6, v7, [Ljava/lang/String;

    .end local v6    # "newArgs":[Ljava/lang/String;
    const/4 v7, 0x0

    aput-object v4, v6, v7

    .restart local v6    # "newArgs":[Ljava/lang/String;
    goto :goto_2

    .line 1133
    :cond_2
    const-string v7, ""

    goto :goto_3

    .line 1141
    .end local v4    # "id":Ljava/lang/String;
    .end local v6    # "newArgs":[Ljava/lang/String;
    :pswitch_3
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v7

    const/4 v8, 0x1

    invoke-interface {v7, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 1142
    .restart local v4    # "id":Ljava/lang/String;
    const-string v8, "fragment"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v9, "_id="

    invoke-direct {v7, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_3

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, " AND ("

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/16 v10, 0x29

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    :goto_4
    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v8, p2, v7, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 1144
    goto/16 :goto_0

    .line 1142
    :cond_3
    const-string v7, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_4

    .line 1114
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method private updateJoinCatalog(Landroid/content/ContentValues;)V
    .locals 12
    .param p1, "aValues"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 1245
    iget-boolean v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->catalog_enabled:Z

    if-nez v8, :cond_0

    .line 1289
    :goto_0
    return-void

    .line 1247
    :cond_0
    iget-object v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 1249
    .local v3, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 1250
    .local v2, "cv":Landroid/content/ContentValues;
    const-string v0, ""

    .line 1251
    .local v0, "assetId":Ljava/lang/String;
    const-string v8, "assetId"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 1252
    const-string v8, "assetId"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1257
    const-string v8, "filePath"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 1258
    const-string v8, "filePath"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1259
    .local v5, "filePath":Ljava/lang/String;
    const-string v8, "filePath"

    invoke-virtual {v2, v8, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1262
    .end local v5    # "filePath":Ljava/lang/String;
    :cond_1
    const-string v8, "uuid"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 1263
    const-string v8, "uuid"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1264
    .local v6, "fileUuid":Ljava/lang/String;
    const-string v8, "fileUuid"

    invoke-virtual {v2, v8, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1269
    const-string v8, "errorType"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 1270
    const-string v8, "errorType"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1271
    .local v4, "errorType":Ljava/lang/String;
    const-string v8, "errorType"

    invoke-virtual {v2, v8, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1274
    .end local v4    # "errorType":Ljava/lang/String;
    :cond_2
    const-string v8, "completeTime"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 1275
    const-string v8, "completeTime"

    invoke-virtual {p1, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1276
    .local v1, "completeTime":Ljava/lang/String;
    const-string v8, "completeTime"

    invoke-virtual {v2, v8, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1279
    .end local v1    # "completeTime":Ljava/lang/String;
    :cond_3
    const-string v8, "catalog"

    const-string v9, "_id=?"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    aput-object v0, v10, v11

    invoke-virtual {v3, v8, v2, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v7

    .line 1280
    .local v7, "mod":I
    if-lez v7, :cond_6

    .line 1281
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v8

    sget-object v9, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->CATALOG_URI_LIST:Landroid/net/Uri;

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1287
    :goto_1
    iget-object v8, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    goto/16 :goto_0

    .line 1254
    .end local v6    # "fileUuid":Ljava/lang/String;
    .end local v7    # "mod":I
    :cond_4
    :try_start_1
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "must supply asset ID"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1286
    .end local v0    # "assetId":Ljava/lang/String;
    .end local v2    # "cv":Landroid/content/ContentValues;
    :catchall_0
    move-exception v8

    .line 1287
    iget-object v9, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v9}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1288
    throw v8

    .line 1266
    .restart local v0    # "assetId":Ljava/lang/String;
    .restart local v2    # "cv":Landroid/content/ContentValues;
    :cond_5
    :try_start_2
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v9, "must supply UUID"

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 1284
    .restart local v6    # "fileUuid":Ljava/lang/String;
    .restart local v7    # "mod":I
    :cond_6
    sget-object v8, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->LOG_TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "update failed: "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method private updateProvider(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 7
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValues"    # Landroid/content/ContentValues;
    .param p3, "aWhere"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 1083
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 1084
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v0, 0x0

    .line 1086
    .local v0, "count":I
    :try_start_0
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 1099
    :pswitch_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Unknown URI "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1103
    :catchall_0
    move-exception v3

    .line 1104
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1105
    throw v3

    .line 1088
    :pswitch_1
    :try_start_1
    const-string v3, "providers"

    invoke-virtual {v1, v3, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    .line 1104
    :goto_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1107
    return v0

    .line 1093
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x1

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1094
    .local v2, "id":Ljava/lang/String;
    const-string v4, "providers"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "_id="

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v6, " AND ("

    invoke-direct {v3, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v6, 0x29

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_1
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v4, p2, v3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 1096
    goto :goto_0

    .line 1094
    :cond_0
    const-string v3, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 1086
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private updateRegistry(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 8
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValues"    # Landroid/content/ContentValues;
    .param p3, "aWhere"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 1292
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 1296
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v4, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 1318
    :pswitch_0
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Unknown URI "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1322
    :catchall_0
    move-exception v4

    .line 1323
    iget-object v5, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v5}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1324
    throw v4

    .line 1298
    :pswitch_1
    :try_start_1
    const-string v4, "registry"

    invoke-virtual {v1, v4, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    .line 1323
    .local v0, "count":I
    :goto_0
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->releaseDatabase()V

    .line 1327
    if-nez v0, :cond_0

    .line 1329
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->insertRegistry(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v3

    .line 1330
    .local v3, "res":Landroid/net/Uri;
    if-eqz v3, :cond_0

    add-int/lit8 v0, v0, 0x1

    .line 1333
    .end local v3    # "res":Landroid/net/Uri;
    :cond_0
    return v0

    .line 1304
    .end local v0    # "count":I
    :pswitch_2
    :try_start_2
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1305
    .local v2, "id":Ljava/lang/String;
    const-string v5, "registry"

    .line 1306
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "name=\'"

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "\'"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v7, " AND ("

    invoke-direct {v4, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v7, 0x29

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    :goto_1
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1305
    invoke-virtual {v1, v5, p2, v4, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 1308
    .restart local v0    # "count":I
    goto :goto_0

    .line 1306
    .end local v0    # "count":I
    :cond_1
    const-string v4, ""

    goto :goto_1

    .line 1312
    .end local v2    # "id":Ljava/lang/String;
    :pswitch_3
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x1

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 1313
    .restart local v2    # "id":Ljava/lang/String;
    const-string v5, "registry"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v6, "_id="

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v7, " AND ("

    invoke-direct {v4, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v7, 0x29

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    :goto_2
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v5, p2, v4, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 1315
    .restart local v0    # "count":I
    goto/16 :goto_0

    .line 1313
    .end local v0    # "count":I
    :cond_2
    const-string v4, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 1296
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public attachInfo(Landroid/content/Context;Landroid/content/pm/ProviderInfo;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "info"    # Landroid/content/pm/ProviderInfo;

    .prologue
    .line 261
    invoke-super {p0, p1, p2}, Landroid/content/ContentProvider;->attachInfo(Landroid/content/Context;Landroid/content/pm/ProviderInfo;)V

    .line 263
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x80

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 264
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    iget-object v1, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 265
    .local v1, "b":Landroid/os/Bundle;
    const-string v3, "com.penthera.virtuososdk.catalog.enabled"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->catalog_enabled:Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 270
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v1    # "b":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 266
    :catch_0
    move-exception v2

    .line 268
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0
.end method

.method public bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    .locals 3
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "values"    # [Landroid/content/ContentValues;

    .prologue
    .line 517
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_0

    .line 518
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->fragmentBulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    move-result v0

    .line 523
    :goto_0
    return v0

    .line 519
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-gtz v0, :cond_1

    .line 520
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-gtz v0, :cond_1

    .line 521
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-gtz v0, :cond_1

    .line 522
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iNetworkUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_2

    .line 523
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/content/ContentProvider;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I

    move-result v0

    goto :goto_0

    .line 526
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Failed to insert bulk unknown uri "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aWhere"    # Ljava/lang/String;
    .param p3, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 556
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_0

    .line 557
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->deleteFile(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 569
    :goto_0
    return v0

    .line 559
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_1

    .line 560
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->deleteRegistry(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 562
    :cond_1
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_2

    .line 563
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->deleteFragment(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 565
    :cond_2
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_3

    .line 566
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->deleteCatalog(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 568
    :cond_3
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_4

    .line 569
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->deleteProvider(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 572
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Failed to delete, unknown URI"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected abstract getAuthority()Ljava/lang/String;
.end method

.method public getDBHandle()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .prologue
    .line 1343
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    return-object v0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 4
    .param p1, "aUri"    # Landroid/net/Uri;

    .prologue
    const/4 v2, 0x1

    .line 274
    const/4 v0, -0x1

    .line 275
    .local v0, "matchNumber":I
    sget-object v1, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_1

    .line 277
    if-ne v0, v2, :cond_0

    .line 278
    const-string v1, "vnd.android.cursor.dir/vnd.virtuososdk.file"

    .line 317
    :goto_0
    return-object v1

    .line 281
    :cond_0
    const-string v1, "vnd.android.cursor.item/vnd.virtuososdk.file"

    goto :goto_0

    .line 284
    :cond_1
    sget-object v1, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_3

    .line 287
    if-ne v0, v2, :cond_2

    .line 288
    const-string v1, "vnd.android.cursor.dir/vnd.virtuososdk.registry"

    goto :goto_0

    .line 291
    :cond_2
    const-string v1, "vnd.android.cursor.item/vnd.virtuososdk.registry"

    goto :goto_0

    .line 294
    :cond_3
    sget-object v1, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_5

    .line 296
    if-ne v0, v2, :cond_4

    .line 297
    const-string v1, "vnd.android.cursor.dir/vnd.virtuososdk.fragment"

    goto :goto_0

    .line 300
    :cond_4
    const-string v1, "vnd.android.cursor.item/vnd.virtuososdk.fragment"

    goto :goto_0

    .line 303
    :cond_5
    sget-object v1, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_7

    .line 305
    if-ne v0, v2, :cond_6

    .line 306
    const-string v1, "vnd.android.cursor.dir/vnd.virtuososdk.Catalog"

    goto :goto_0

    .line 309
    :cond_6
    const-string v1, "vnd.android.cursor.item/vnd.virtuososdk.Catalog"

    goto :goto_0

    .line 312
    :cond_7
    sget-object v1, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_9

    .line 313
    if-ne v0, v2, :cond_8

    .line 314
    const-string v1, "vnd.android.cursor.dir/vnd.virtuososdk.provider"

    goto :goto_0

    .line 317
    :cond_8
    const-string v1, "vnd.android.cursor.item/vnd.virtuososdk.provider"

    goto :goto_0

    .line 321
    :cond_9
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unknown URI "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public handleMessage(Landroid/os/Message;)Z
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 1339
    const/4 v0, 0x0

    return v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 3
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValueSet"    # Landroid/content/ContentValues;

    .prologue
    const/4 v1, 0x1

    .line 328
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-ne v0, v1, :cond_0

    .line 329
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->insertFile(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    .line 341
    :goto_0
    return-object v0

    .line 331
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-ne v0, v1, :cond_1

    .line 332
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->insertRegistry(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 334
    :cond_1
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-ne v0, v1, :cond_2

    .line 335
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->insertFragment(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 337
    :cond_2
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-ne v0, v1, :cond_3

    .line 338
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->insertCatalog(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 340
    :cond_3
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-ne v0, v1, :cond_4

    .line 341
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->insertProvider(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 344
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unknown URI "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onCreate()Z
    .locals 3

    .prologue
    .line 249
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->LOG_TAG:Ljava/lang/String;

    const-string v1, "getting helper"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 250
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->getInstance()Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    move-result-object v0

    if-nez v0, :cond_0

    .line 251
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Orpheus Db is null. initialising..."

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 252
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->init(Landroid/content/Context;Ljava/lang/String;)V

    .line 254
    :cond_0
    invoke-static {}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->getHelper()Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    .line 255
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "helper is "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->mOpenHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 3
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aProjection"    # [Ljava/lang/String;
    .param p3, "aSelection"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;
    .param p5, "aSortOrder"    # Ljava/lang/String;

    .prologue
    .line 838
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_0

    .line 839
    invoke-direct/range {p0 .. p5}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->queryFile(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 851
    :goto_0
    return-object v0

    .line 841
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_1

    .line 842
    invoke-direct/range {p0 .. p5}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->queryRegistry(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0

    .line 844
    :cond_1
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_2

    .line 845
    invoke-direct/range {p0 .. p5}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->queryFragment(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0

    .line 847
    :cond_2
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_3

    .line 848
    invoke-direct/range {p0 .. p5}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->queryCatalog(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0

    .line 850
    :cond_3
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_4

    .line 851
    invoke-direct/range {p0 .. p5}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->queryProvider(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0

    .line 854
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Failed to query, unknown URI: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3
    .param p1, "aUri"    # Landroid/net/Uri;
    .param p2, "aValues"    # Landroid/content/ContentValues;
    .param p3, "aWhere"    # Ljava/lang/String;
    .param p4, "aArgs"    # [Ljava/lang/String;

    .prologue
    .line 1061
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFileUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_0

    .line 1062
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->updateFile(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 1074
    :goto_0
    return v0

    .line 1064
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iRegistryUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_1

    .line 1065
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->updateRegistry(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 1067
    :cond_1
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iFragmentUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_2

    .line 1068
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->updateFragment(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 1070
    :cond_2
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iCatalogUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_3

    .line 1071
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->updateCatalog(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 1073
    :cond_3
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->iProviderUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v0, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    if-lez v0, :cond_4

    .line 1074
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider;->updateProvider(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 1077
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Failed to update, unknown URI"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
