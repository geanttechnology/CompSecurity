.class final Lcom/localytics/android/MigrationDatabaseHelper$ApiKeysDbColumns;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/provider/BaseColumns;


# static fields
.field static final API_KEY:Ljava/lang/String; = "api_key"

.field static final CREATED_TIME:Ljava/lang/String; = "created_time"

.field static final OPT_OUT:Ljava/lang/String; = "opt_out"

.field static final TABLE_NAME:Ljava/lang/String; = "api_keys"

.field static final UUID:Ljava/lang/String; = "uuid"


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 407
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 408
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "This class is non-instantiable"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
