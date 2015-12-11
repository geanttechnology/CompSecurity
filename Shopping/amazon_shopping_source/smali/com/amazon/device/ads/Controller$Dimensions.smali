.class public Lcom/amazon/device/ads/Controller$Dimensions;
.super Lcom/amazon/device/ads/Controller$ReflectedParcelable;
.source "Controller.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/Controller;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Dimensions"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/device/ads/Controller$Dimensions;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public height:I

.field public width:I

.field public x:I

.field public y:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 100
    new-instance v0, Lcom/amazon/device/ads/Controller$Dimensions$1;

    invoke-direct {v0}, Lcom/amazon/device/ads/Controller$Dimensions$1;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/Controller$Dimensions;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 116
    invoke-direct {p0}, Lcom/amazon/device/ads/Controller$ReflectedParcelable;-><init>()V

    .line 117
    iput v0, p0, Lcom/amazon/device/ads/Controller$Dimensions;->x:I

    .line 118
    iput v0, p0, Lcom/amazon/device/ads/Controller$Dimensions;->y:I

    .line 119
    iput v0, p0, Lcom/amazon/device/ads/Controller$Dimensions;->width:I

    .line 120
    iput v0, p0, Lcom/amazon/device/ads/Controller$Dimensions;->height:I

    .line 121
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 0
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 125
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/Controller$ReflectedParcelable;-><init>(Landroid/os/Parcel;)V

    .line 126
    return-void
.end method
