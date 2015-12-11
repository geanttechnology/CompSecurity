.class public Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private description:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2430
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2431
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;->title:Ljava/lang/String;

    .line 2432
    iput-object p2, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;->value:Ljava/lang/String;

    .line 2433
    iput-object p3, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;->description:Ljava/lang/String;

    .line 2434
    return-void
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2445
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2437
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2441
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;->value:Ljava/lang/String;

    return-object v0
.end method
