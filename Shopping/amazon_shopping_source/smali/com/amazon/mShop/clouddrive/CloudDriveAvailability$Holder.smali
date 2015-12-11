.class Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$Holder;
.super Ljava/lang/Object;
.source "CloudDriveAvailability.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Holder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 21
    new-instance v0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;-><init>(Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$1;)V

    sput-object v0, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability$Holder;->INSTANCE:Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
