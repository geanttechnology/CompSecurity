.class public Lcom/poshmark/user/UserInfoDetails$AB_Segment;
.super Ljava/lang/Object;
.source "UserInfoDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/user/UserInfoDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "AB_Segment"
.end annotation


# instance fields
.field sign_up:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/user/UserInfoDetails;


# direct methods
.method public constructor <init>(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lcom/poshmark/user/UserInfoDetails$AB_Segment;->this$0:Lcom/poshmark/user/UserInfoDetails;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
