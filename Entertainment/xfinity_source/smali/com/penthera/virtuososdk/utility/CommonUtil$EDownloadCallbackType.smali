.class public final enum Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
.super Ljava/lang/Enum;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EDownloadCallbackType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum ECollectionComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum ECollectionProgress:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum ECollectionsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum ECollectionsDeleted:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EDownloadEnd:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EDownloadQueueChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EDownloadStart:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EDownloadedListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EFragmentComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EFullListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EItemUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EListFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EListFilesIteratively:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EProgressUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum ESettingsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

.field public static final enum EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 153
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EStatusChange"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 154
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EDownloadStart"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadStart:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 155
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EProgressUpdate"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EProgressUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 156
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EDownloadEnd"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadEnd:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 157
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EDownloadQueueChanged"

    invoke-direct {v0, v1, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadQueueChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 158
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EDownloadedListChanged"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadedListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 159
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EFullListChanged"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFullListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 160
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EListFiles"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EListFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 161
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EListFilesIteratively"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EListFilesIteratively:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 162
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "ESettingsChanged"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ESettingsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 163
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EItemUpdate"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 164
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "ECollectionsChanged"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 165
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "ECollectionsDeleted"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionsDeleted:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 166
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "ECollectionProgress"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionProgress:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 167
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "ECollectionComplete"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 168
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EFragmentComplete"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFragmentComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 169
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    const-string v1, "EItemDownloadRemoved"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    .line 152
    const/16 v0, 0x11

    new-array v0, v0, [Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadStart:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EProgressUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadEnd:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadQueueChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadedListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFullListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EListFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EListFilesIteratively:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ESettingsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionsDeleted:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionProgress:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFragmentComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 152
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
