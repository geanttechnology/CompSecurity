.class final Lcom/localytics/android/MarketingProvider$FrequencyCappingBlackoutTimeV3Columns;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/provider/BaseColumns;


# static fields
.field static final END_TIME:Ljava/lang/String; = "end"

.field static final FREQUENCY_ID:Ljava/lang/String; = "frequency_id"

.field static final RULE_GROUP_ID:Ljava/lang/String; = "rule_group_id"

.field static final START_TIME:Ljava/lang/String; = "start"

.field static final TABLE_NAME:Ljava/lang/String; = "frequency_capping_blackout_times"


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 655
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 656
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "This class is non-instantiable"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
