.class public final Lcom/auditude/ads/util/log/LogLevel;
.super Ljava/lang/Object;
.source "LogLevel.java"


# static fields
.field public static final ALL:Lcom/auditude/ads/util/log/LogLevel;

.field public static final DEBUG:Lcom/auditude/ads/util/log/LogLevel;

.field public static final ERROR:Lcom/auditude/ads/util/log/LogLevel;

.field public static final FATAL:Lcom/auditude/ads/util/log/LogLevel;

.field public static final INFO:Lcom/auditude/ads/util/log/LogLevel;

.field public static final WARN:Lcom/auditude/ads/util/log/LogLevel;


# instance fields
.field private name:Ljava/lang/String;

.field private verbosity:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 29
    new-instance v0, Lcom/auditude/ads/util/log/LogLevel;

    const/16 v1, 0x3e8

    const-string v2, "FATAL"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/util/log/LogLevel;-><init>(ILjava/lang/String;)V

    sput-object v0, Lcom/auditude/ads/util/log/LogLevel;->FATAL:Lcom/auditude/ads/util/log/LogLevel;

    .line 35
    new-instance v0, Lcom/auditude/ads/util/log/LogLevel;

    const/16 v1, 0x8

    const-string v2, "ERROR"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/util/log/LogLevel;-><init>(ILjava/lang/String;)V

    sput-object v0, Lcom/auditude/ads/util/log/LogLevel;->ERROR:Lcom/auditude/ads/util/log/LogLevel;

    .line 41
    new-instance v0, Lcom/auditude/ads/util/log/LogLevel;

    const/4 v1, 0x6

    const-string v2, "WARN"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/util/log/LogLevel;-><init>(ILjava/lang/String;)V

    sput-object v0, Lcom/auditude/ads/util/log/LogLevel;->WARN:Lcom/auditude/ads/util/log/LogLevel;

    .line 47
    new-instance v0, Lcom/auditude/ads/util/log/LogLevel;

    const/4 v1, 0x4

    const-string v2, "INFO"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/util/log/LogLevel;-><init>(ILjava/lang/String;)V

    sput-object v0, Lcom/auditude/ads/util/log/LogLevel;->INFO:Lcom/auditude/ads/util/log/LogLevel;

    .line 54
    new-instance v0, Lcom/auditude/ads/util/log/LogLevel;

    const/4 v1, 0x2

    const-string v2, "DEBUG"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/util/log/LogLevel;-><init>(ILjava/lang/String;)V

    sput-object v0, Lcom/auditude/ads/util/log/LogLevel;->DEBUG:Lcom/auditude/ads/util/log/LogLevel;

    .line 59
    new-instance v0, Lcom/auditude/ads/util/log/LogLevel;

    const/4 v1, 0x0

    const-string v2, "ALL"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/util/log/LogLevel;-><init>(ILjava/lang/String;)V

    sput-object v0, Lcom/auditude/ads/util/log/LogLevel;->ALL:Lcom/auditude/ads/util/log/LogLevel;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "verbosity"    # I
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput p1, p0, Lcom/auditude/ads/util/log/LogLevel;->verbosity:I

    .line 14
    iput-object p2, p0, Lcom/auditude/ads/util/log/LogLevel;->name:Ljava/lang/String;

    .line 15
    return-void
.end method


# virtual methods
.method public getVerbosity()I
    .locals 1

    .prologue
    .line 17
    iget v0, p0, Lcom/auditude/ads/util/log/LogLevel;->verbosity:I

    return v0
.end method
