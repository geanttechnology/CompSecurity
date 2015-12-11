.class public Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver$MasAction;
.super Ljava/lang/Object;
.source "MasEventReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MasAction"
.end annotation


# static fields
.field public static final AuthenticationSuccessAction:Ljava/lang/String; = "com.amazon.mas.client.authentication.action.AUTHENTICATION_SUCCESS_ACTION"

.field public static final DdiRefreshSuccessful:Ljava/lang/String; = "com.amazon.mas.client.tokenrefresh.TokenRefreshService.ddi.refresh.successful"

.field public static final UserDeregisteredAction:Ljava/lang/String; = "com.amazon.mas.client.authentication.action.USER_DEREGISTERED_ACTION"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
