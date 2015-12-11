.class public abstract Lcom/amazon/mShop/ui/DrawableFactory;
.super Ljava/lang/Object;
.source "DrawableFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;
    }
.end annotation


# static fields
.field private static DEFAULT_DRAWABLE_FACTORY_KEY:Ljava/lang/String;

.field private static sFactoryMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 13
    const-string/jumbo v0, "default_factory"

    sput-object v0, Lcom/amazon/mShop/ui/DrawableFactory;->DEFAULT_DRAWABLE_FACTORY_KEY:Ljava/lang/String;

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/ui/DrawableFactory;->sFactoryMap:Ljava/util/Map;

    .line 18
    sget-object v0, Lcom/amazon/mShop/ui/DrawableFactory;->DEFAULT_DRAWABLE_FACTORY_KEY:Ljava/lang/String;

    new-instance v1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;

    invoke-direct {v1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/mShop/ui/DrawableFactory;->registerFactory(Ljava/lang/String;Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;)Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    .line 19
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/mShop/ui/DrawableFactory;->DEFAULT_DRAWABLE_FACTORY_KEY:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance(Ljava/lang/String;)Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(Ljava/lang/String;)Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;
    .locals 2
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 30
    sget-object v1, Lcom/amazon/mShop/ui/DrawableFactory;->sFactoryMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    .line 31
    .local v0, "factory":Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;
    return-object v0
.end method

.method public static registerFactory(Ljava/lang/String;Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;)Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "factory"    # Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/mShop/ui/DrawableFactory;->sFactoryMap:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    return-object v0
.end method
