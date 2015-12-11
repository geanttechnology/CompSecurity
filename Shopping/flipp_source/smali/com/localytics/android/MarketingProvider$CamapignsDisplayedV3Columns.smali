.class final Lcom/localytics/android/MarketingProvider$CamapignsDisplayedV3Columns;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/provider/BaseColumns;


# static fields
.field static final CAMPAIGN_ID:Ljava/lang/String; = "campaign_id"

.field static final DATE:Ljava/lang/String; = "date"

.field static final IGNORE_GLOBAL:Ljava/lang/String; = "ignore_global"

.field static final TABLE_NAME:Ljava/lang/String; = "campaigns_displayed"


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 702
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 703
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "This class is non-instantiable"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
