.class public Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapterFactory;
.super Ljava/lang/Object;
.source "SnuffyNoConnectionViewAdapterFactory.java"

# interfaces
.implements Lcom/amazon/venezia/web/NoConnectionViewAdapterFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createNoConnectionViewAdapter(Landroid/view/View;I)Lcom/amazon/venezia/web/NoConnectionViewAdapter;
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "id"    # I

    .prologue
    .line 11
    new-instance v0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;-><init>(Landroid/view/View;I)V

    return-object v0
.end method
