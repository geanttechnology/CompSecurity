.class Lcom/amazon/device/ads/MraidAbstractController;
.super Ljava/lang/Object;
.source "MraidAbstractController.java"


# instance fields
.field private final mView:Lcom/amazon/device/ads/MraidView;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/amazon/device/ads/MraidAbstractController;->mView:Lcom/amazon/device/ads/MraidView;

    .line 19
    return-void
.end method


# virtual methods
.method public getView()Lcom/amazon/device/ads/MraidView;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/device/ads/MraidAbstractController;->mView:Lcom/amazon/device/ads/MraidView;

    return-object v0
.end method
