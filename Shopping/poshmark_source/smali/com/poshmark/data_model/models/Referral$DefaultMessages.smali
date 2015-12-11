.class public Lcom/poshmark/data_model/models/Referral$DefaultMessages;
.super Ljava/lang/Object;
.source "Referral.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/Referral;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "DefaultMessages"
.end annotation


# instance fields
.field public email_body:Ljava/lang/String;

.field public email_subject:Ljava/lang/String;

.field public fb_desc:Ljava/lang/String;

.field public fb_img_url:Ljava/lang/String;

.field public fb_share:Ljava/lang/String;

.field public fb_share_url:Ljava/lang/String;

.field public fb_title:Ljava/lang/String;

.field public sms:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/Referral;

.field public tm_share:Ljava/lang/String;

.field public tw_share:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/Referral;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->this$0:Lcom/poshmark/data_model/models/Referral;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
