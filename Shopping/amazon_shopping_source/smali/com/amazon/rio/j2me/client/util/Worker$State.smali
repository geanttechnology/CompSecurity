.class public Lcom/amazon/rio/j2me/client/util/Worker$State;
.super Ljava/lang/Object;
.source "Worker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/rio/j2me/client/util/Worker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "State"
.end annotation


# static fields
.field public static final EXECUTING:Lcom/amazon/rio/j2me/client/util/Worker$State;

.field public static final IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

.field public static final STOPPED:Lcom/amazon/rio/j2me/client/util/Worker$State;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 13
    new-instance v0, Lcom/amazon/rio/j2me/client/util/Worker$State;

    const-string/jumbo v1, "IDLE"

    invoke-direct {v0, v1}, Lcom/amazon/rio/j2me/client/util/Worker$State;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/rio/j2me/client/util/Worker$State;->IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

    .line 14
    new-instance v0, Lcom/amazon/rio/j2me/client/util/Worker$State;

    const-string/jumbo v1, "EXECUTING"

    invoke-direct {v0, v1}, Lcom/amazon/rio/j2me/client/util/Worker$State;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/rio/j2me/client/util/Worker$State;->EXECUTING:Lcom/amazon/rio/j2me/client/util/Worker$State;

    .line 15
    new-instance v0, Lcom/amazon/rio/j2me/client/util/Worker$State;

    const-string/jumbo v1, "STOPPED"

    invoke-direct {v0, v1}, Lcom/amazon/rio/j2me/client/util/Worker$State;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/rio/j2me/client/util/Worker$State;->STOPPED:Lcom/amazon/rio/j2me/client/util/Worker$State;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amazon/rio/j2me/client/util/Worker$State;->name:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/Worker$State;->name:Ljava/lang/String;

    return-object v0
.end method
