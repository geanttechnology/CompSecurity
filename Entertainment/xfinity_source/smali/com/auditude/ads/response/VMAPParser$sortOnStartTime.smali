.class public Lcom/auditude/ads/response/VMAPParser$sortOnStartTime;
.super Ljava/lang/Object;
.source "VMAPParser.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/response/VMAPParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "sortOnStartTime"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/auditude/ads/response/VMAPAdBreak;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/auditude/ads/response/VMAPParser;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/response/VMAPParser;)V
    .locals 0

    .prologue
    .line 615
    iput-object p1, p0, Lcom/auditude/ads/response/VMAPParser$sortOnStartTime;->this$0:Lcom/auditude/ads/response/VMAPParser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/auditude/ads/response/VMAPAdBreak;Lcom/auditude/ads/response/VMAPAdBreak;)I
    .locals 2
    .param p1, "adBreak1"    # Lcom/auditude/ads/response/VMAPAdBreak;
    .param p2, "adBreak2"    # Lcom/auditude/ads/response/VMAPAdBreak;

    .prologue
    .line 619
    invoke-virtual {p1}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v0

    invoke-virtual {p2}, Lcom/auditude/ads/response/VMAPAdBreak;->getStartTime()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 1
    check-cast p1, Lcom/auditude/ads/response/VMAPAdBreak;

    check-cast p2, Lcom/auditude/ads/response/VMAPAdBreak;

    invoke-virtual {p0, p1, p2}, Lcom/auditude/ads/response/VMAPParser$sortOnStartTime;->compare(Lcom/auditude/ads/response/VMAPAdBreak;Lcom/auditude/ads/response/VMAPAdBreak;)I

    move-result v0

    return v0
.end method
