.class public final enum Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;
.super Ljava/lang/Enum;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "BearerAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum EDownload:Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

.field public static final enum EUpload:Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 134
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    const-string v1, "EUpload"

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->EUpload:Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    .line 135
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    const-string v1, "EDownload"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->EDownload:Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    .line 133
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->EUpload:Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    aput-object v1, v0, v2

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->EDownload:Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    aput-object v1, v0, v3

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 133
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
