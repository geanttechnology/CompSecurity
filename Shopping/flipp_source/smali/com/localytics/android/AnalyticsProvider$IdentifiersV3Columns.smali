.class final Lcom/localytics/android/AnalyticsProvider$IdentifiersV3Columns;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/provider/BaseColumns;


# static fields
.field static final KEY:Ljava/lang/String; = "key"

.field static final TABLE_NAME:Ljava/lang/String; = "identifiers"

.field static final VALUE:Ljava/lang/String; = "value"


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 189
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 190
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "This class is non-instantiable"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
