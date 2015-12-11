.class public final enum Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
.super Ljava/lang/Enum;
.source "Common.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/Common;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EFileDownloadStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum KvDE_Download_Complete_Pending_Integrity_Check:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_HLS_Fragment_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kvDE_Collection_Partially_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field public static final enum kvDE_HLS_Manifest_Processing:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 192
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_Not_Pending"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 195
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 196
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_Pending"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 199
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 200
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Downloading"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 203
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 204
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_Network_Error"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 207
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 208
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_Reachability_Error"

    invoke-direct {v0, v1, v7}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 211
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 212
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_File_Copy_Error"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 215
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 216
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_File_Mime_Mismatch"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 219
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 224
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_File_Size_Mismatch"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 228
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_File_Corrupt"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 232
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "KvDE_Download_Complete_Pending_Integrity_Check"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete_Pending_Integrity_Check:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 236
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "KvDE_Download_Complete"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 240
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kvDE_Expired"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 241
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kvDE_Collection_Partially_Complete"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 244
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Collection_Partially_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 245
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kvDE_HLS_Manifest_Processing"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 248
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_HLS_Manifest_Processing:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 249
    new-instance v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    const-string v1, "kVDE_Download_HLS_Fragment_Copy_Error"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;-><init>(Ljava/lang/String;I)V

    .line 252
    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_HLS_Fragment_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 191
    const/16 v0, 0xf

    new-array v0, v0, [Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v1, v0, v6

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete_Pending_Integrity_Check:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Collection_Partially_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_HLS_Manifest_Processing:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_HLS_Fragment_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 191
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
