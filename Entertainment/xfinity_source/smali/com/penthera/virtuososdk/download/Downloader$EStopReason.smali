.class public final enum Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
.super Ljava/lang/Enum;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EStopReason"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/download/Downloader$EStopReason;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum EBlocked:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

.field public static final enum EFileExpired:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

.field public static final enum EFileRemoved:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

.field public static final enum ENone:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

.field public static final enum EPriorityChange:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 696
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    const-string v1, "ENone"

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->ENone:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    const-string v1, "EBlocked"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EBlocked:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    const-string v1, "EPriorityChange"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EPriorityChange:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    const-string v1, "EFileRemoved"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EFileRemoved:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    const-string v1, "EFileExpired"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EFileExpired:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->ENone:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    aput-object v1, v0, v2

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EBlocked:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EPriorityChange:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EFileRemoved:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EFileExpired:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    aput-object v1, v0, v6

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->ENUM$VALUES:[Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 696
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->ENUM$VALUES:[Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
