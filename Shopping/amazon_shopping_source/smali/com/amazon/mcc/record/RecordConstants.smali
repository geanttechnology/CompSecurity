.class public final Lcom/amazon/mcc/record/RecordConstants;
.super Ljava/lang/Object;
.source "RecordConstants.java"


# static fields
.field public static final RECORD_TOPIC:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/amazon/mcc/record/Recorder;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mcc/record/RecordConstants;->RECORD_TOPIC:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    return-void
.end method
