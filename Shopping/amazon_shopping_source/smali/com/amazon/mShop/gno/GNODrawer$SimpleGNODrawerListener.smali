.class public Lcom/amazon/mShop/gno/GNODrawer$SimpleGNODrawerListener;
.super Ljava/lang/Object;
.source "GNODrawer.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SimpleGNODrawerListener"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 483
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 497
    return-void
.end method

.method public onDrawerOpened(Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 492
    return-void
.end method

.method public onDrawerSlide(Lcom/amazon/mShop/gno/GNODrawer;F)V
    .locals 0
    .param p1, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;
    .param p2, "slideOffset"    # F

    .prologue
    .line 487
    return-void
.end method
