.class public Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppExperimentProvider;
.super Ljava/lang/Object;
.source "VoiceSearchInitializer.java"

# interfaces
.implements Lcom/amazon/shopapp/voice/module/ExperimentProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/voice/VoiceSearchInitializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "AppExperimentProvider"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V
    .locals 0

    .prologue
    .line 168
    iput-object p1, p0, Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppExperimentProvider;->this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getTreatment(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 171
    invoke-static {}, Lcom/amazon/mShop/feature/ExperimentRecorder;->getInstance()Lcom/amazon/mShop/feature/ExperimentRecorder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/feature/ExperimentRecorder;->getTreatment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
