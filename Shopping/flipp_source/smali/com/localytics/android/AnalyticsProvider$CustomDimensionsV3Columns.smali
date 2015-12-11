.class final Lcom/localytics/android/AnalyticsProvider$CustomDimensionsV3Columns;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/provider/BaseColumns;


# static fields
.field static final CUSTOM_DIMENSION_KEY:Ljava/lang/String; = "custom_dimension_key"

.field static final CUSTOM_DIMENSION_VALUE:Ljava/lang/String; = "custom_dimension_value"

.field static final TABLE_NAME:Ljava/lang/String; = "custom_dimensions"


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 112
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "This class is non-instantiable"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
