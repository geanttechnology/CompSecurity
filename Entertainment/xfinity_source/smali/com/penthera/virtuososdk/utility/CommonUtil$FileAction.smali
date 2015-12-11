.class public final enum Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
.super Ljava/lang/Enum;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FileAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum EAdd:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum EAddToCollection:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum EExpire:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum EListAllFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum EListDownloaded:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum EListQueued:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum EMove:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum ERemove:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum ERemoveAll:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum ERemoveAllFromQueue:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

.field public static final enum EUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 139
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EAdd"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EAdd:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 140
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EAddToCollection"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EAddToCollection:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 141
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EMove"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EMove:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 142
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "ERemove"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ERemove:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 143
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EListQueued"

    invoke-direct {v0, v1, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListQueued:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 144
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EListDownloaded"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListDownloaded:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 145
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EListAllFiles"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListAllFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 146
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "ERemoveAllFromQueue"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ERemoveAllFromQueue:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 147
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "ERemoveAll"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ERemoveAll:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 148
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EExpire"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EExpire:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 149
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    const-string v1, "EUpdate"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    .line 138
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EAdd:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EAddToCollection:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EMove:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ERemove:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v1, v0, v6

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListQueued:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListDownloaded:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListAllFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ERemoveAllFromQueue:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ERemoveAll:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EExpire:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 138
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
