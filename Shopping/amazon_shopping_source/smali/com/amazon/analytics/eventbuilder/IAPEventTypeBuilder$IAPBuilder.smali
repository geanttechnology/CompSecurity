.class public Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$IAPBuilder;
.super Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;
.source "IAPEventTypeBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IAPBuilder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;-><init>(Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$1;)V

    return-void
.end method


# virtual methods
.method getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    const-string/jumbo v0, "iap"

    return-object v0
.end method
