.class public final enum Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
.super Ljava/lang/Enum;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EDownloadPermission"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field public static final enum EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field public static final enum EDownloadBlockedBattery:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field public static final enum EDownloadBlockedCell:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field public static final enum EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field public static final enum EDownloadBlockedPaused:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field public static final enum EDownloadBlockedStorage:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field public static final enum EDownloadBlockedWifi:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 116
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadAllowed"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 117
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadBlockedCell"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 118
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadBlockedBattery"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 119
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadBlockedHeadroom"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 120
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadBlockedStorage"

    invoke-direct {v0, v1, v7}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 121
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadBlockedPaused"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 122
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadBlockedAuthentication"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 123
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    const-string v1, "EDownloadBlockedWifi"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedWifi:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 115
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v1, v0, v6

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedWifi:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ENUM$VALUES:[Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 115
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ENUM$VALUES:[Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
