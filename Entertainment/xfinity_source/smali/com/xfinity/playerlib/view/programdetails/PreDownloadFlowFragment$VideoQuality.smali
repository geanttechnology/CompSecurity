.class final enum Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;
.super Ljava/lang/Enum;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "VideoQuality"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

.field public static final enum DEFAULT:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

.field public static final enum HIGH:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

.field public static final enum LOW:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 158
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    const-string v1, "HIGH"

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->HIGH:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    const-string v1, "LOW"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->LOW:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    const-string v1, "DEFAULT"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->DEFAULT:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    .line 157
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    sget-object v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->HIGH:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->LOW:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->DEFAULT:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->$VALUES:[Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 157
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 157
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;
    .locals 1

    .prologue
    .line 157
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->$VALUES:[Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    return-object v0
.end method
