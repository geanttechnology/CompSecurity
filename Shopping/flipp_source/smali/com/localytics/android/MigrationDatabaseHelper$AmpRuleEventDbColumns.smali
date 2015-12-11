.class final Lcom/localytics/android/MigrationDatabaseHelper$AmpRuleEventDbColumns;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/provider/BaseColumns;


# static fields
.field static final EVENT_NAME:Ljava/lang/String; = "event_name"

.field static final RULE_ID_REF:Ljava/lang/String; = "rule_id_ref"

.field static final TABLE_NAME:Ljava/lang/String; = "amp_ruleevent"


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 1466
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1467
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "This class is non-instantiable"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
