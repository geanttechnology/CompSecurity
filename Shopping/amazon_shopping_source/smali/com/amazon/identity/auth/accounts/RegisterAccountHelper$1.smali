.class Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;
.super Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;
.source "RegisterAccountHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->ensureCredentialsSynchronouslyPopulated(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

.field final synthetic val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->this$0:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->val$callback:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/callback/AsyncToSyncAdapter;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->asyncOperationComplete()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->asyncOperationComplete()V

    return-void
.end method


# virtual methods
.method protected startAsyncOperation()V
    .locals 3

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1$1;-><init>(Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;)V

    .line 74
    .local v0, "wrappedCallback":Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->this$0:Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->ensureCredentialsPopulated(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/RegisterAccountHelper$FetchCredentialsCallback;)V

    .line 75
    return-void
.end method
