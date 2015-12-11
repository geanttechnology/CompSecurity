.class Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;
.super Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;
.source "PersonalizedSuggestionLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RequestListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;",
        ">;"
    }
.end annotation


# instance fields
.field private serviceCall:Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

.field final synthetic this$0:Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;

    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;
    .param p2, "x1"    # Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$1;

    .prologue
    .line 128
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;)V

    return-void
.end method

.method static synthetic access$102(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;)Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;
    .param p1, "x1"    # Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    return-object p1
.end method


# virtual methods
.method public error(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;

    # getter for: Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;->access$200(Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    const-string/jumbo v1, "Personalized ISS request error"

    iget-object v2, p0, Lcom/amazon/retailsearch/data/PersonalizedSuggestionLoader$RequestListener;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    invoke-interface {v0, v1, p1, v2}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->searchSRDSPersonalizedISSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;)V

    .line 136
    return-void
.end method
