.class final Lcom/localytics/android/MarketingProvider$FrequencyCappingDisplayFrequencyV3Columns;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/provider/BaseColumns;


# static fields
.field static final DISPLAY_FREQUENCY_COUNT:Ljava/lang/String; = "count"

.field static final DISPLAY_FREQUENCY_DAYS:Ljava/lang/String; = "days"

.field static final FREQUENCY_ID:Ljava/lang/String; = "frequency_id"

.field static final TABLE_NAME:Ljava/lang/String; = "frequency_capping_display_frequencies"


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 498
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 499
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "This class is non-instantiable"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
